package com.asiainfo.rms.core.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.Integer.toHexString;

/**
 * 加密解密算法.
 */
public class MD5Util {

    private MD5Util(){

    }
    //private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);
    /**
     * 进行MD5加密 获取公司服务的加密服务.
     *
     * @param info 要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException ex) {
            //logger.info(ex.getMessage(),ex);
        }
        // 将摘要转为字符串
        return byte2hex(digesta);
    }


    /**
     * 将二进制转化为16进制字符串.
     *
     * @param bt 二进制字节数组
     * @return String
     */
    private static String byte2hex(byte[] bt) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (byte aBt : bt) {
            stmp = (toHexString(aBt & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            //logger.info(e.getMessage(),e);
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(toHexString(val));
        }
        return hexValue.toString();
    }

}
