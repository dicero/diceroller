package com.dicero.diceroller.test.service;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.Derivation;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.ExtendedKey;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.Hash;
import com.dicero.diceroller.core.coin.util.bitcoin.bip32.Seed;
import com.dicero.diceroller.core.coin.util.crypto.util.ByteUtil;
import com.dicero.diceroller.dal.mysql.repository.EthAddressPORepository;
import com.dicero.diceroller.domain.model.EthAddressPO;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Security;

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

    public static boolean TEST_V = true;
    public static String TEST_KEYHASH = "243d9080ee35193511ebc1fab00acdfbeb135d0901bbaa0b5b7c66d3df7ea752d354d8b75cdc7b03d3af916cf3e18f00aaca455526322bf1e0352d12de7e7155";
    public static String TEST_CHAINCODE = "d354d8b75cdc7b03d3af916cf3e18f00aaca455526322bf1e0352d12de7e7155";
    public static String TEST_PUBLIC = "xpub661MyMwAqRbcGeU4wEhPkAW7BL8Z5PL7X3AUxLq2mrYDMBdhLG16AxQx4GdjsfF8gzz2xCZRh8Bm1QSMCAUKeCGt5Tehb1acfRtnYY2XEw7";
    public static String TEST_PRIVATE = "xprv9s21ZrQH143K4APbqDAPP2ZNdJJ4fvcG9pEt9xRRDX1EUPJYnigqdA6UD1Y1pT3TuD1M19QjDgMgZSaqG46sAnMkaeUkcdNTPAmho29hBvu";

    @Test
    public void bitchSaveTest() throws Exception {
        boolean compressed = true;
        String passphrase = "crazy horse battery staple";
        String seed = Seed.BITCOIN_SEED;
        String func = "SHA-256";
        int rounds = 50000;

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
        if(TEST_V) Assert.assertTrue(TEST_PUBLIC.equals(extendedPubKey));

        String extendedPrivKey = extendedKey.serializePrivate();
        System.out.println("private: " + extendedPrivKey);
        if(TEST_V) Assert.assertTrue(TEST_PRIVATE.equals(extendedPrivKey));

        for (int j = 0; j < 3; j++) {
            String path = "m/" + j;
            Derivation derivation = new Derivation(extendedKey);
            ExtendedKey child = derivation.derive(path);

            System.out.println("====" + j + "====");
            System.out.println("path: " + path);
            System.out.println("public: " + child.serializePublic());
            System.out.println("publicHex: " + child.getPublicHex());
            System.out.println("private: " + child.serializePrivate());
            System.out.println("address: " + child.getAddress().toString());
            System.out.println("wif: " + child.getWIF());

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
