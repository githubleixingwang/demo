//package com.demo.vue.test;
//
//import lombok.experimental.UtilityClass;
//import lombok.extern.slf4j.Slf4j;
//import org.bouncycastle.asn1.gm.GMNamedCurves;
//import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
//import org.bouncycastle.asn1.x9.X9ECParameters;
//import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
//import org.bouncycastle.crypto.InvalidCipherTextException;
//import org.bouncycastle.crypto.engines.SM2Engine;
//import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
//import org.bouncycastle.crypto.params.*;
//import org.bouncycastle.util.encoders.Hex;
//
//import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
//import java.security.SecureRandom;
//
///**
// * SM2工具类，数据以16进制字符存储
// *
// * @author YS
// */
//@Slf4j
//@UtilityClass
//public class SM2Kit {
//
//	private static final ECDomainParameters EC_DOMAIN_PARAMETERS;
//
//	static {
//		X9ECParameters parameters = GMNamedCurves.getByOID(GMObjectIdentifiers.sm2p256v1);
//		EC_DOMAIN_PARAMETERS = new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN());
//	}
//
//	/**
//	 * 生成密钥对
//	 */
//	public static AsymmetricCipherKeyPair generateKeyPair() {
//		ECKeyPairGenerator keyPairGenerator = new ECKeyPairGenerator();
//		ECKeyGenerationParameters aKeyGenParams = new ECKeyGenerationParameters(EC_DOMAIN_PARAMETERS, new SecureRandom());
//		keyPairGenerator.init(aKeyGenParams);
//		return keyPairGenerator.generateKeyPair();
//	}
//
//	/**
//	 * 获取16进制公钥
//	 *
//	 * @param keypair 密钥对
//	 */
//	public static String getPublicKey(AsymmetricCipherKeyPair keypair) {
//		return getPublicKey((ECPublicKeyParameters) keypair.getPublic());
//	}
//
//	/**
//	 * 获取16进制私钥
//	 *
//	 * @param keypair 密钥对
//	 */
//	public static String getPrivateKey(AsymmetricCipherKeyPair keypair) {
//		return getPrivateKey((ECPrivateKeyParameters) keypair.getPrivate());
//	}
//
//	/**
//	 * 获取16进制公钥字符串
//	 *
//	 * @param publicKey 公钥
//	 */
//	public static String getPublicKey(ECPublicKeyParameters publicKey) {
//		return Hex.toHexString((publicKey.getQ().getEncoded(false))).toUpperCase()
//				;
//	}
//
//	/**
//	 * 获取16进制私钥字符串
//	 *
//	 * @param privateKey 公钥
//	 */
//	public static String getPrivateKey(ECPrivateKeyParameters privateKey) {
//		return Hex.toHexString(privateKey.getD().toByteArray()).toUpperCase();
//	}
//
//	/**
//	 * 加密
//	 *
//	 * @param publicKey 16进制公钥字符串
//	 * @param data      明文
//	 * @return 加密后16进制字符串
//	 */
//	public static String encrypt(String data, String publicKey) {
//		try {
//			return encrypt(data.getBytes("UTF-8"), Hex.decode(publicKey));
//		} catch (UnsupportedEncodingException e) {
//			log.error("不支持的编码格式", e);
//			return null;
//		}
//	}
//
//	/**
//	 * 加密 使用默认公钥
//	 *
//	 * @param data 明文
//	 * @return 加密后16进制字符串
//	 */
//	public static String encrypt(String data) {
//		try {
//			return encrypt(data.getBytes("UTF-8"), Hex.decode(SM2Holder.getX().getB()));
//		} catch (UnsupportedEncodingException e) {
//			log.error("不支持的编码格式", e);
//			return null;
//		}
//	}
//
//	/**
//	 * 加密
//	 *
//	 * @param publicKey 16进制公钥字符串
//	 * @param data      待加密字节数据
//	 * @return 加密后16进制字符串
//	 */
//	private static String encrypt(byte[] data, byte[] publicKey) {
//		if (publicKey == null || publicKey.length == 0) {
//			return null;
//		}
//		if (data == null || data.length == 0) {
//			return null;
//		}
//		ECPublicKeyParameters key = new ECPublicKeyParameters(EC_DOMAIN_PARAMETERS.getCurve().decodePoint(publicKey), EC_DOMAIN_PARAMETERS);
//		SM2Engine sm2Engine = new SM2Engine();
//		sm2Engine.init(true, new ParametersWithRandom(key, new SecureRandom()));
//
//		byte[] enc;
//		try {
//			enc = sm2Engine.processBlock(data, 0, data.length);
//			return Hex.toHexString(enc).toUpperCase();
//		} catch (InvalidCipherTextException e) {
//			log.error("非法的待加密数据", e);
//			return null;
//		}
//	}
//
//	/**
//	 * 解密 使用默认公钥
//	 *
//	 * @param encryptedData 16进制密文
//	 * @return 解密后数据
//	 */
//	public static String decrypt(String encryptedData) {
//		return decrypt(encryptedData, SM2Holder.getX().getA());
//	}
//
//	/**
//	 * 解密
//	 *
//	 * @param privateKey    16进制私钥字符串
//	 * @param encryptedData 16进制密文字符串
//	 * @return 解密后数据
//	 */
//	public static String decrypt(String encryptedData, String privateKey) {
//		byte[] data = decrypt2Bytes(Hex.decode(encryptedData), Hex.decode(privateKey));
//		if (data == null) {
//			return null;
//		}
//		try {
//			return new String(data, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			log.error("非法的待解密数据", e);
//			return null;
//		}
//	}
//
//	/**
//	 * 解密为16进制数据
//	 *
//	 * @param privateKey    16进制私钥字符串
//	 * @param encryptedData 16进制密文字符串
//	 * @return 解密后的十六进制的数据
//	 */
//	public static String decrypt2Hex(String encryptedData, String privateKey) {
//		final byte[] data = decrypt2Bytes(Hex.decode(encryptedData), Hex.decode(privateKey));
//		return Hex.toHexString(data);
//	}
//
//	/**
//	 * 解密为16进制数据 使用默认公钥
//	 *
//	 * @param encryptedData 16进制密文
//	 * @return 解密后的十六进制的数据
//	 */
//	public static String decrypt2Hex(String encryptedData) {
//		return decrypt2Hex(encryptedData, SM2Holder.getX().getA());
//	}
//
//	/**
//	 * 解密
//	 *
//	 * @param privateKey    二进制私钥
//	 * @param encryptedData 二进制密文
//	 * @return 解密后数据的字节流
//	 */
//	private static byte[] decrypt2Bytes(byte[] encryptedData, byte[] privateKey) {
//		if (privateKey == null || privateKey.length == 0) {
//			return null;
//		}
//
//		if (encryptedData == null || encryptedData.length == 0) {
//			return null;
//		}
//		ECPrivateKeyParameters key = new ECPrivateKeyParameters(new BigInteger(privateKey), EC_DOMAIN_PARAMETERS);
//		SM2Engine sm2Engine = new SM2Engine();
//		sm2Engine.init(false, key);
//		try {
//			return sm2Engine.processBlock(encryptedData, 0, encryptedData.length);
//		} catch (Exception e) {
//			log.error("非法的待解密数据", e);
//			return null;
//		}
//	}
//
//}