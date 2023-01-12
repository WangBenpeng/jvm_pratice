package com.pengo.jvm_pratice.remote_execution;

/**
 * Bytes数组处理工具
 * @author Benpeng
 * @date 2023/1/3
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int)b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++) {
            b[len - i - 1] = (byte) (((value >> 8 * i)) & 0xff);
        }
        return b;
    }

    public static String bytes2String(byte[] b, int start, int len) {
        return new String(b, start, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceByte) {
        byte[] newBytes = new byte[originalBytes.length + (replaceByte.length - len)];
        System.arraycopy(originalBytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceByte, 0, newBytes, offset, replaceByte.length);
        System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceByte.length, originalBytes.length);
        return newBytes;
    }

    public static void main(String[] args) {
        byte[] bytes = int2Bytes(2, 1);
        System.out.println(bytes);
        int i = bytes2Int(bytes, 0, 1);
        System.out.println(i);
    }
}
