package com.rfchina.internet.mytestapp.aliRecognition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.rfchina.internet.mytestapp.R;
import com.rfchina.internet.mytestapp.utils.AliRecognitionEntityWrapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by luoyican on 2017/8/28.
 */

public class AliRecognitionActivity extends Activity {
    private static final String URL = "http://yhk.market.alicloudapi.com/rest/160601/ocr/ocr_bank_card.json";
    private static final int TAKE_PHONTO = 1;
    private static final int CHOOSE_PHONTO = 2;
    private TextView resultView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        resultView = (TextView) findViewById(R.id.button3);
    }

    public void start(View view) {
        choosePic();
    }

    public void pause(View view) {
        openTakePhoto();
    }

    public void cancel(View view) {
        getAppDetailSettingIntent();
    }

    private void getAppDetailSettingIntent() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
//        } else if (Build.VERSION.SDK_INT <= 8) {
//            localIntent.setAction(Intent.ACTION_VIEW);
//            localIntent.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
//            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
//        }
        startActivity(localIntent);
    }

    private void openTakePhoto() {
        /**
         * 在启动拍照之前最好先判断一下sdcard是否可用
         */
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)) {   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, TAKE_PHONTO);
        } else {
            Toast.makeText(this, "sdcard不可用", Toast.LENGTH_SHORT).show();
        }
    }

    private void choosePic() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, CHOOSE_PHONTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_PHONTO) {
                Toast.makeText(this, "拍照成功", Toast.LENGTH_LONG).show();
            } else if (requestCode == CHOOSE_PHONTO) {
                //获得图片的uri
                final Uri uri = data.getData();
                Log.d("TAG", uri.toString());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        requestHttp(uri);
                    }
                }).start();
            }
        }
    }

    private void requestHttp(Uri uri) {
        String appcode = "369d5374511c44729d3cdeeebae5652f";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json = "{\"inputs\": [ {\"image\": {\"dataType\":50,\"dataValue\": \"" + bitmap2Base64(file2Bitmap(uri)) + "\"}}]}";
        Log.d("TAG", json);
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        final Request request = new Request.Builder()
                .url(URL)
                .header("Authorization", "APPCODE " + appcode)
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .post(body)
                .build();
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(AliRecognitionActivity.this, "正在请求网络，请等待", Toast.LENGTH_LONG).show();
                }

            });
            final Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                final String re = response.body().string();//只能用一次response.body()
                final Object object = com.alibaba.fastjson.JSON.parseObject(re, AliRecognitionEntityWrapper.class, Feature.SupportNonPublicField);
                String dataValue =((AliRecognitionEntityWrapper) object).getOutputs().get(0).getOutputValue().getDataValue().replace("\\","");
                final AliRecognitionEntityWrapper.OutputsBean.OutputValueBean.DataValueBean dataValueBean = com.alibaba.fastjson.JSON.parseObject(dataValue, AliRecognitionEntityWrapper.OutputsBean.OutputValueBean.DataValueBean.class, Feature.SupportNonPublicField);
                Log.d("TAG", dataValueBean.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AliRecognitionActivity.this, dataValueBean.isSuccess() + "", Toast.LENGTH_LONG).show();
                        resultView.setText(object.toString());
                    }
                });
            } else {
                Log.d("TAG", response.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AliRecognitionActivity.this, response + "", Toast.LENGTH_LONG).show();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 本地图片生成 bitmap
     *
     * @param uri
     * @return
     */
    private Bitmap file2Bitmap(Uri uri) {
        Bitmap photoBmp = null;
        try {
            InputStream input = getContentResolver().openInputStream(uri);
            BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
            onlyBoundsOptions.inJustDecodeBounds = true;
            onlyBoundsOptions.inDither = true;//optional
            onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
            BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
            input.close();
            int originalWidth = onlyBoundsOptions.outWidth;
            int originalHeight = onlyBoundsOptions.outHeight;
            if ((originalWidth == -1) || (originalHeight == -1))
                return null;
            //图片分辨率以480x800为标准
            float hh = 800f;//这里设置高度为800f
            float ww = 480f;//这里设置宽度为480f
            //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
            int be = 1;//be=1表示不缩放
            if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
                be = (int) (originalWidth / ww);
            } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
                be = (int) (originalHeight / hh);
            }
            if (be <= 0)
                be = 1;
            //比例压缩
            BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
            bitmapOptions.inSampleSize = be;//设置缩放比例
            bitmapOptions.inDither = true;//optional
            bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
            input = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
            input.close();
            return compressImage(bitmap);//再进行质量压缩
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photoBmp;
    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    private String bitmap2Base64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

}
