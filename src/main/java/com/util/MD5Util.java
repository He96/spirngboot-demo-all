package com.util;

import java.security.MessageDigest;

/**
 * MD5工具类
 */
public class MD5Util {
    public static String convertByteToHexString(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        for(int x=0;x<bytes.length;x++){
            String temp = Integer.toHexString(bytes[x] & 0xff);
            if(temp.length() < 2){
                stringBuffer.append("0").append(temp);
            }else{
                stringBuffer.append(temp);
            }

        }
        return stringBuffer.toString();
    }


    public static String MD2(String string)throws Exception{
        MessageDigest messageDigest  = MessageDigest.getInstance("MD2");
        return convertByteToHexString(messageDigest.digest(string.getBytes()));
    }

    public static String MD5(String string){
        try {
            MessageDigest messageDigest  = MessageDigest.getInstance("MD5");
            return convertByteToHexString(messageDigest.digest(string.toLowerCase().trim().getBytes()));
        }catch (Exception ex){

            return null;
        }
    }
}
