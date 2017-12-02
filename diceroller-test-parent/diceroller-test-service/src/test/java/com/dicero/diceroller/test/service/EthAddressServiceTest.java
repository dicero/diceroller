package com.dicero.diceroller.test.service;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.Derivation;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.ExtendedKey;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.Hash;
import com.dicero.diceroller.core.coin.util.crypto.util.ByteUtil;
import com.dicero.diceroller.dal.mysql.repository.EthAddressPORepository;
import com.dicero.diceroller.domain.model.EthAddressPO;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/2
 */
public class EthAddressServiceTest extends TestBase {
    @Autowired EthAddressPORepository ethAddressPORepository;

    @BeforeClass
    public static void init ()
    {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static boolean TEST_V = true;
    private static String TEST_KEYHASH = "243d9080ee35193511ebc1fab00acdfbeb135d0901bbaa0b5b7c66d3df7ea752d354d8b75cdc7b03d3af916cf3e18f00aaca455526322bf1e0352d12de7e7155";
    private static String TEST_CHAINCODE = "d354d8b75cdc7b03d3af916cf3e18f00aaca455526322bf1e0352d12de7e7155";
    private static String TEST_PUBLIC = "xpub661MyMwAqRbcGeU4wEhPkAW7BL8Z5PL7X3AUxLq2mrYDMBdhLG16AxQx4GdjsfF8gzz2xCZRh8Bm1QSMCAUKeCGt5Tehb1acfRtnYY2XEw7";
    private static String TEST_PRIVATE = "xprv9s21ZrQH143K4APbqDAPP2ZNdJJ4fvcG9pEt9xRRDX1EUPJYnigqdA6UD1Y1pT3TuD1M19QjDgMgZSaqG46sAnMkaeUkcdNTPAmho29hBvu";

    private static String passphrase = "crazy horse battery staple";
    private static String seed = "Bitcoin seed";

    private static int startIndex = 0;
    private static int endIndex = 0;
    private static boolean needSave = false;

    private static boolean compressed = true;
    private static String func = "SHA-256";
    private static int rounds = 50000;

    @Test
    public void bitchSaveTest() throws Exception {

        System.out.println("==== Parent ====");
        byte[] passphraseHash = new Hash(passphrase, rounds, func).hash();
        byte[] keyHash = new Hash(passphraseHash).getHmacSHA512(seed);
        System.out.println("keyhash: " + ByteUtil.toHex(keyHash));
        if(TEST_V) Assert.assertTrue(TEST_KEYHASH.equals(ByteUtil.toHex(keyHash)));

        ExtendedKey extendedKey = new ExtendedKey(keyHash, compressed);
        String chainCode = ByteUtil.toHex(extendedKey.getChainCode());
        System.out.println("chainCode: " + chainCode);
        if(TEST_V) Assert.assertTrue(TEST_CHAINCODE.equals(chainCode));

        String extendedPubKey = extendedKey.serializePublic();
        System.out.println("public: " + extendedPubKey);
        System.out.println("publicHex: " + extendedKey.getECKey().getPublicHex().toString());
        System.out.println("toBigIntNoPrefix: " + Numeric.toBigIntNoPrefix(extendedKey.getECKey().getPublicHex()));
        System.out.println("toHexStringWithPrefix: " + Numeric.toHexStringWithPrefix(Numeric.toBigIntNoPrefix(extendedKey.getECKey().getPublicHex())));
//        System.out.println("getPublicHex: " + extendedKey.getECKey().getPublicHex());
//        System.out.println("SHA256 getPublic: " + EncryptUtil.SHA256(extendedKey.getECKey().getPublic().toString()));

        if(TEST_V) Assert.assertTrue(TEST_PUBLIC.equals(extendedPubKey));


        System.out.println("-----------" );
        System.out.println("address: " + extendedKey.getAddress());
        System.out.println("SHA256 address: " + ByteUtil.toHex(extendedKey.getAddress().getHash()));
        System.out.println("-----------" );

        /**
         * private key: 'b4cb99aa52ed6ef2cb230a2956194720f7e4435947cf058779fc1e1c0b46f087'
         public key: 'xprv9s21ZrQH143K3rktAZZcNb5k7s4VxcWra2xVUkjZXNMbxQS18h3DDCQDGyVRTLfD4eBZ8QtunXaU8Uru6eSRJH6Q7eDBPWWxee7uQCuidaj'
         address: '0x748748f823d358aacf928b93b5c7ad47b3b56029'
         */
        String extendedPrivKey = extendedKey.serializePrivate();
        System.out.println("private: " + extendedPrivKey);
        System.out.println("getPriv: " + extendedKey.getECKey().getPriv());
        System.out.println("私钥得出公钥: " + EncryptUtil.SHA256(Sign.publicKeyFromPrivate(extendedKey.getECKey().getPriv()).toString()));
        System.out.println("SHA256 getPriv: " + EncryptUtil.SHA256(extendedKey.getECKey().getPriv().toString()));
        System.out.println("SHA256 getPriv: " + extendedKey.getECKey().getPriv());
        System.out.println("随机私钥: " +  EncryptUtil.SHA256("hhahha"));
        System.out.println("随机私钥: " +  ByteUtil.toBase58WithChecksum(EncryptUtil.SHA256("hhahha").getBytes()));

        if(TEST_V) Assert.assertTrue(TEST_PRIVATE.equals(extendedPrivKey));

        List<EthAddressPO> ethAddressPOList = new ArrayList<>();
        for (int j = startIndex; j < endIndex; j++) {
            String path = "m/" + j;
            Derivation derivation = new Derivation(extendedKey);
            ExtendedKey child = derivation.derive(path);

            System.out.println("====" + j + "====");
            System.out.println("path: " + path);
            System.out.println("public: " + child.serializePublic());
            System.out.println("publicHex: " + child.getPublicHex());
            System.out.println("private: " + child.serializePrivate());
            System.out.println("address: " + child.getAddress().toString());

            System.out.println("getPriv: " + child.getECKey().getPriv());
            System.out.println("getPriv: " + child.getECKey().getPriv());
            System.out.println("getPrivate: " + child.getECKey().getPrivate().toString());
            System.out.println("getPublicHex: " + child.getECKey().getPublicHex());
            System.out.println("getPublic: " + child.getECKey().getPublic().toString());
            System.out.println("wif: " + child.getWIF());

            ethAddressPOList.add(createEthAddressPO(child.getAddress().toString(), child.serializePublic(), child.serializePrivate()));
        }

        if (needSave) {
            for (EthAddressPO ethAddressPO : ethAddressPOList) {
                ethAddressPORepository.save(ethAddressPO);
            }
        }

    }

    private static EthAddressPO createEthAddressPO(String address, String xpub, String xpri){
        EthAddressPO ethAddressPO = new EthAddressPO();
        ethAddressPO.setHasUse(0);
        ethAddressPO.setAddress(address);
        ethAddressPO.setXpub(xpub);
        ethAddressPO.setXpri(xpri);
        ethAddressPO.setCreateTime(now);
        ethAddressPO.setUpdateTime(now);
        return ethAddressPO;
    }

}
