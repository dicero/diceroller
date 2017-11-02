package com.dicero.diceroller.service.play.impl;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/3
 */
public class DiceHmacStrategy {
    /**
     *
     //crypto lib for hmac function
     var crypto = require('crypto');

     var roll = function(key, text) {

     //create HMAC using server seed as key and client seed as message
     var hash = crypto.createHmac('sha512', key).update(text).digest('hex');

     var index = 0;

     var lucky = parseInt(hash.substring(index * 5, index * 5 + 5), 16);

     //keep grabbing characters from the hash while greater than
     while (lucky >= Math.pow(10, 6)) {
     index++;
     lucky = parseInt(hash.substring(index * 5, index * 5 + 5), 16);

     //if we reach the end of the hash, just default to highest number
     if (index * 5 + 5 > 128) {
     lucky = 99.99;
     break;
     }
     }

     lucky %= Math.pow(10, 4);
     lucky /= Math.pow(10, 2);

     return lucky;
     }

     console.log(roll(serverSeed, clientSeed+'-'+nonce));
     * @param serverSeed
     * @param clientSeed
     * @param nonce
     * @return
     */
    public static double hmacStrategy(String serverSeed, String clientSeed, String nonce) {
        String hash = hmacSHA512(serverSeed, clientSeed + "-"+ nonce);
        int index = 0;

        double lucky = Integer.parseInt(hash.substring(index * 5, index * 5 + 5), 16);

        while (lucky >= Math.pow(10, 6)) {
            index++;
            lucky = Integer.parseInt(hash.substring(index * 5, index * 5 + 5), 16);

            if (index * 5 + 5 > 128) {
                lucky = 99.99;
                break;
            }
        }

        lucky %= Math.pow(10, 4);
        lucky /= Math.pow(10, 2);

        return lucky;
    }

    public static void main(String[] args) {
        String serverSeed = "ba38a75edf6fae6d52a8b010351d5c2d71966a85194ca582ab804ac72997af4c";

        String clientSeed = "6042534133898";

        String nonce = "1";

        String result = "cedc5026aa79a44c8624012c58919e63dec6a44997ed4a7fd61e02934853abb89698abc75783116d86c7ffbccf4397fe82889b34e3a22e3ea9172af1b1816027";
        // crypto.createHmac('sha512', serverSeed).update(clientSeed+ nonce).digest('hex');
        for (int i=0; i<50;i++) {
            System.out.println(hmacStrategy(serverSeed, clientSeed, String.valueOf(i)));
        }
    }

    /**
     * 与php中的hash_hmac('sha512', $data, $key)功能相同
     * @param data
     * @param key
     * @return
     */
    public static  String hmacSHA512(String key, String data) {
        String result = "";
        byte[] bytesKey = data.getBytes();
        final SecretKeySpec secretKey = new SecretKeySpec(bytesKey, "HmacSHA512");
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(secretKey);
            final byte[] macData = mac.doFinal(key.getBytes());
            byte[] hex = new Hex().encode(macData);
            result = new String(hex, "ISO-8859-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
