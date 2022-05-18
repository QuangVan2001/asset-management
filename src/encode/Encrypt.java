package encode;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quang Van
 */
public class Encrypt {
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static byte[] getDigest(String algorithmName, byte[] input){
        MessageDigest md;
        try{
            md = MessageDigest.getInstance(algorithmName);
        }catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input);
        return result;
    }
    
    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b : bytes){
            String apart = String.format("%02x", b);
            sb.append(apart);
        }
        return sb.toString();
    }
    
    public static String getHexaDigest(String algorithmName, String src){
        byte[] inputBytes = src.getBytes(UTF_8);
        byte[] encryptedBytes = getDigest(algorithmName, inputBytes);
        return bytesToHex(encryptedBytes);
    }
    
    public static void output(String msg, String data){
        System.out.println(msg + ":" + data + "\nLen= " + data.length());
    }
}
