package com.example.item.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Utils {

    /**
     * SHA512 加密
     *
     * @param password 1
     * @return 1
     */
    public static String encryptPasswordWithSHA512(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");  //创建SHA512类型的加密对象
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder strHexString = new StringBuilder();
            for (byte aByte : bytes) {
                String hex = Integer.toHexString(0xff & aByte);
                if (hex.length() == 1) {
                    strHexString.append('0');
                }
                strHexString.append(hex);
            }
            return strHexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
