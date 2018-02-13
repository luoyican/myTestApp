package com.rfchina.internet.mytestapp.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by luoyican on 2018/2/12.
 */

public class TCPServerService extends Service {
    private boolean isServiceDestoryed = false;
    private String[] definedMessage = new String[]{
            "春节放假去哪玩啊",
            "哪也不去，宅",
            "哟哟哟",
            "好人一生平安",
            "会当临绝顶，一览众山小",
            "略似粉黛顾倾城",
            "回眸一笑百媚生"
    };

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new TcpServer()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isServiceDestoryed = true;
    }

    private class TcpServer implements Runnable {
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                //监听本地端口
                serverSocket = new ServerSocket(8888);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            while (!isServiceDestoryed) {
                try {
                    //接受客户端请求
                    final Socket client = serverSocket.accept();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                responseClient(client);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void responseClient(Socket socket) throws IOException {
            //用于接收客户端消息
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //用于向客户端发送消息
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            out.println("你来啦,大兄弟，等你很久咯");
            while (!isServiceDestoryed) {
                String str = in.readLine();
                if (str == null) {
                    //客户端断开连接
                    break;
                }
                int i = new Random().nextInt(definedMessage.length);
                String msg = definedMessage[i];
                out.println(msg);
            }
            //关闭流
            in.close();
            out.close();
            socket.close();
        }
    }
}
