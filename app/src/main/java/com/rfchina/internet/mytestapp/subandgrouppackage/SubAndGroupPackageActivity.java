package com.rfchina.internet.mytestapp.subandgrouppackage;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luoyican on 2018/1/16.
 */

public class SubAndGroupPackageActivity extends Activity {
    String msg = "Hello,Indian Mifans, Are you ok? I am find, nice to see you again.1122 " +
            "Hello,Indian Mifans, Are you ok? I am find, nice to see you again.123 " +
            "Hello,Indian Mifans, Are you ok? I am find, nice to see you again.123445 ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        packageData(msg,19);
//        StringBuilder tmpMsg = new StringBuilder();
//        String resultString = "";
//        int serNum = 0;
//        for (int j = 0; j < msg.length(); j++) {
//            tmpMsg.append(msg.charAt(j));
//            if (j == 18 || j == 18 + 19 * serNum || j == msg.length() - 1) {
//                byte[] bytes = DataUtil.packageSignData(tmpMsg.toString(), (serNum++) % 2, j / 18 <= 1, j == msg.length() - 1);
//                String tmpByte = "";
//                for (int i = 0; i < bytes.length; i++) {
//                    tmpByte += bytes[i] + ",";
//                }
//                Log.e("mmmmmmm", bytes.length + ":" + tmpByte);
//                Log.e("mmmmmmm", DataUtil.Bytes2String(bytes));
//                Log.e("mmmmmmm", DataUtil.byte2BitString(bytes[0]));
//                tmpMsg.delete(0, tmpMsg.length());
//                resultString += DataUtil.decodeByte(bytes);
//            }
//        }
//
//        Log.e("mmmmmmm", resultString);
    }

    private void packageData(String msg,int byteLen) {
        InputStream inputStream = new ByteArrayInputStream(msg.getBytes());
        byte[] bufferByte = new byte[byteLen];
        String resultString = "";
        int serNum = 0;
        try {
            int len = inputStream.read(bufferByte);
            boolean isEnd = false;
            while (!isEnd) {
                if (len != byteLen) isEnd = true;
                byte[] bytes = DataUtil.packageSignData(len, bufferByte, (serNum++) % 2, serNum == 1, isEnd);
                len = inputStream.read(bufferByte);
                String tmpByte = "";
                for (int i = 0; i < bytes.length; i++) {
                    tmpByte += bytes[i] + ",";
                }
                Log.e("mmmmmmm", bytes.length + ":" + tmpByte);
                Log.e("mmmmmmm", DataUtil.Bytes2String(bytes));
                Log.e("mmmmmmm", DataUtil.byte2BitString(bytes[0]));
                resultString += DataUtil.decodeByte(bytes);
            }
            Log.e("mmmmmmm", resultString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
