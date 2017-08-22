package com.rfchina.internet.mytestapp.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.rfchina.internet.mytestapp.R;

import java.io.File;

public class DownloadService extends Service {
    public static final int NOTI_ID = 1;
    private DownloadTask downloadTask;
    private String downloadUrl;

    private DownloadListener mDownloadListener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(NOTI_ID, getNotification("正在下载ing", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功时将前台服务通知关闭，并创建一个下载成功通知
            stopForeground(true);
            getNotificationManager().notify(NOTI_ID, getNotification("下载完成", -1));
            Toast.makeText(DownloadService.this, "下载成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFail() {
            downloadTask = null;
            //下载失败时将前台服务通知关闭，并创建一个下载失败通知
            stopForeground(true);
            getNotificationManager().notify(NOTI_ID, getNotification("下载失败", -1));
            Toast.makeText(DownloadService.this, "下载失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPause() {
            downloadTask = null;
            Toast.makeText(DownloadService.this, "暂停下载", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            downloadTask = null;
            stopForeground(true);
            Toast.makeText(DownloadService.this, "下载取消", Toast.LENGTH_SHORT).show();
        }
    };

    private DownloadBinder mDownloadBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
       return mDownloadBinder;
    }

     class DownloadBinder extends Binder {
        public void startDownload(String url) {
            if (downloadTask == null) {
                downloadUrl = url;
                downloadTask = new DownloadTask(mDownloadListener);
                downloadTask.execute(downloadUrl);
                startForeground(NOTI_ID, getNotification("正在下载中", 0));
                Toast.makeText(DownloadService.this, "开始下载", Toast.LENGTH_SHORT).show();
            }
        }

        public void pauseDownload() {
            if (downloadTask != null) {
                downloadTask.pauseDownload();
            }
        }

        public void cancelDownload() {
            if (downloadTask != null) {
                downloadTask.cancelDownload();
            } else {
                if (downloadUrl != null) {
                    //取消时需将文件删除，并通知关闭
                    String fileName = downloadUrl.contains("/") ? downloadUrl.substring(downloadUrl.lastIndexOf("/")) : "test";
                    String derectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(derectory + fileName);
                    if (file.exists()) {
                        file.delete();
                    }
                    getNotificationManager().cancel(NOTI_ID);
                    stopForeground(true);
                    Toast.makeText(DownloadService.this, "取消下载", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    private Notification getNotification(String title, int progress) {
        Intent intent = new Intent(this, ServiceActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.w));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if (progress > 0) {
            //d当下载进度大于或等于0时才显示下载进度
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }
        return builder.build();
    }
}
