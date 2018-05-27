package com.wl.seekmarry.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ${温宇航} on 2018/1/5.
 */

public class MD5Utils {
    public static String md5(String inputStr) throws NoSuchAlgorithmException {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(inputStr.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
