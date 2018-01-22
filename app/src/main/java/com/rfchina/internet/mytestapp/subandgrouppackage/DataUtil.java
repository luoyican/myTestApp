package com.rfchina.internet.mytestapp.subandgrouppackage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by luoyican on 2018/1/16.
 */

public class DataUtil {
    public static final int serinalNumBit = 0x80;//1000 0000
    public static final int firstBit = 0x40;//0100 0000
    public static final int lastBit = 0x20;//0010 0000


    /**
     * String 转byte
     *
     * @param msg 需要字节化的字符串
     * @return
     **/
    public static byte[] String2Bytes(String msg) {
        byte[] bytes = msg.getBytes();
        return bytes;
    }

    /**
     * String 转 byte 指定编码模式
     *
     * @param msg     需要字节化的字符串
     * @param charset 编码方式
     * @return
     **/
    public static byte[] String2Bytes(String msg, Charset charset) {
        byte[] bytes = msg.getBytes(charset);
        return bytes;
    }

    /**
     * byte String
     *
     * @param bytes
     * @return
     **/
    public static String Bytes2String(byte[] bytes) {
        String msg = new String(bytes);
        return msg;
    }

    /**
     * byte 转 String 指定编码模式
     *
     * @param bytes
     * @param charset 编码方式
     * @return
     **/
    public static String Bytes2String(byte[] bytes, Charset charset) {
        String msg = new String(bytes, charset);
        return msg;
    }

    /**
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     *
     * @param b
     * @return 返回代表8bit的byte数组
     */
    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }

    /**
     * 把byte转为字符串的bit
     *
     * @param b
     * @return 返回String型的8bit串
     */
    public static String byte2BitString(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    /**
     * 二进制字符串转byte
     *
     * @param bitStr
     * @return 返回byte
     */
    public static byte bitString2byte(String bitStr) {
        int re, len;
        if (null == bitStr) {
            return 0;
        }
        len = bitStr.length();
        if (len != 4 && len != 8) {
            return 0;
        }
        if (len == 8) {// 8 bit处理
            if (bitStr.charAt(0) == '0') {// 正数
                re = Integer.parseInt(bitStr, 2);
            } else {// 负数
                re = Integer.parseInt(bitStr, 2) - 256;
            }
        } else {// 4 bit处理
            re = Integer.parseInt(bitStr, 2);
        }
        return (byte) re;
    }

    /**
     * String 转成以bit形式的String类型
     *
     * @param msg
     * @return String
     */
    public static String String2BitString(String msg) {
        byte[] bytes = DataUtil.String2Bytes(msg);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(DataUtil.byte2BitString(b));
        }
        return sb.toString();
    }

    /**
     * InputStream 转为 byte
     *
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
    public static byte[] inputStream2Byte(InputStream inStream)
            throws Exception {
        int count = 0;
        while (count == 0) {
            count = inStream.available();
        }
        byte[] b = new byte[count];
        inStream.read(b);
        return b;
    }

    /**
     * byte 转为 InputStream
     *
     * @param b
     * @return InputStream
     * @throws Exception
     */
    public static InputStream byte2InputStream(byte[] b) throws Exception {
        InputStream is = new ByteArrayInputStream(b);
        return is;
    }

    /**
     * String 数据加上序列号、开始位、结束位、数据大小组成定长byte数组(默认20byte)
     * 第一个字节为信息位，00011111前三位bit分别代表序列号、开始位、结束位，后五位代表数据的大小
     *
     * @param byteRealSize 定长的bufferByte实际有效数据大小
     * @param bufferByte   封装的数据
     * @param isFirstData  是否是第一条数据
     * @param isLastData   是否是最后一条数据
     * @param serialNum    序列号 保证数据的连续性
     * @return byte[]
     */
    public static byte[] packageSignData(int byteRealSize, byte[] bufferByte, int serialNum, boolean isFirstData, boolean isLastData) {
        return DataUtil.packageSignData(20, byteRealSize, bufferByte, serialNum, isFirstData, isLastData);
    }

    /**
     * String 数据加上序列号、开始位、结束位、数据大小组成定长byte数组
     * 第一个字节为信息位，00011111前三位bit分别代表序列号、开始位、结束位，后五位代表数据的大小
     *
     * @param packageLen 需要封装成新的byte[]的长度
     * @param byteRealSize 定长的bufferByte实际有效数据大小
     * @param bufferByte  封装的数据
     * @param isFirstData 是否是第一条数据
     * @param isLastData  是否是最后一条数据
     * @param serialNum   序列号 保证数据的连续性
     * @return byte[]
     */
    public static byte[] packageSignData(int packageLen, int byteRealSize, byte[] bufferByte, int serialNum, boolean isFirstData, boolean isLastData) {
        byte[] bytes = new byte[packageLen];
        int serNum = serialNum == 1 ? serinalNumBit : 0;
        int first = isFirstData ? firstBit : 0;
        int last = isLastData ? lastBit : 0;
        int firstByte = serNum | first | last | byteRealSize;
        bytes[0] = (byte) firstByte;
        System.arraycopy(bufferByte, 0, bytes, 1, byteRealSize);
        return bytes;
    }

    /**
     * byte[] 数据解码为String
     *
     * @param b 封装的数据
     * @return String
     */
    public static String decodeByte(byte[] b) {
        if (b.length == 0) return "";
        int firstByte = (int) b[0];
        int serNum = serinalNumBit & firstByte;
        int first = firstBit & firstByte;
        int last = lastBit & firstByte;
        int size = 0x1f & firstByte;
        byte[] tmpByte = new byte[size];
        System.arraycopy(b, 1, tmpByte, 0, size);
        return DataUtil.Bytes2String(tmpByte);
    }
}
