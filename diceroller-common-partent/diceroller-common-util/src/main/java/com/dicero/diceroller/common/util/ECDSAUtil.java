package com.dicero.diceroller.common.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/19
 */
public class ECDSAUtil {
    public static void main(String[] args) {
        String src = "dddd4343534ferg5gc5t5cg5g5c566c5556c5gc5cc55c55cd";
        String sign = signSHA256withECDSA(src);
        System.out.println(sign);
        System.out.println(verifySHA256withECDSA(src, sign));
    }

    public static String signSHA256withECDSA(String message){
        return ecdsa(message, "SHA256withECDSA");
    }

    public static String signSHA512withECDSA(String message){
        return ecdsa(message, "SHA512withECDSA");
    }

    public static boolean verifySHA256withECDSA(String message, String sign) {
        return verifyEcdsa(message, sign, "SHA256withECDSA");
    }

    private static ECPublicKey ecPublicKey;
    private static ECPrivateKey ecPrivateKey;

    private static void init(){
        try {
            if (ecPublicKey == null) {
//                1.初始化密钥
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
                keyPairGenerator.initialize(256);
                KeyPair keyPair = keyPairGenerator.generateKeyPair();
                ecPublicKey = (ECPublicKey) keyPair.getPublic();
                ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String ecdsa(final String src, final String strType) {
        String result = "";
        try {
            init();
            //2.执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());

            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance(strType);
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            byte[] res = signature.sign();
            result = HexBin.encode(res);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    private static boolean verifyEcdsa(final String src, final String sign, final String strType){
        boolean bool = false;
        try {
            //3.验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Signature signature = Signature.getInstance(strType);
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            bool = signature.verify(HexBin.decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }
}
