package Security;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class practice2 {

	public static void main(String[] args) {


		// 내가 보낸 키, 암호
	       String key1 = "kopoctc404040401";
	          String originalText1 =  "대충 대충 넘어가지마라;";
	       
	          // 해석이 보낸 키, 암호
	        String key2 = "kopoctc404040401";
	        String originalText2 =  "2bUyfiuR+9rWZoW5f0XDREBDZziE1ayDjOSRgOEwKHA=";
	        
	       // 교안에서 보낸 키, 암호
	        String key3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa777";
	        String originalText3 =  "ruDZ3CTS5Md3+ipVKt20hQ==";

		

       

	        // 암호화
	         String encryptedText = encrypt(key1, originalText1);
	         System.out.println("Encrypted Text: " + encryptedText);
	         
	         // 복호화
	         String decryptedText = decrypt(key2, originalText2);
	         System.out.println("Decrypted Text: " + decryptedText);
	         
	         // 교안 복호화
	         String decryptedText2 = decrypt(key3, originalText3);
	         System.out.println("Decrypted Text: " + decryptedText2);

		
	}

	public static String encrypt(String key, String text) {
		String cipherText = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(key.getBytes("UTF-8"),0,cipher.getBlockSize()));
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), ivspec);
			cipherText = new String(Base64.encodeBase64(cipher.doFinal(text.getBytes("UTF-8"))),"UTF-8");
		}catch(Exception e) {
			cipherText = "";
			e.printStackTrace();
			}
		return cipherText;
	}
	
	public static String decrypt(String key, String encryptedText) {
		String plainText = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(key.getBytes("UTF-8"),0,cipher.getBlockSize()));
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("UTF-8"), "AES"), ivspec);
			plainText = new String(cipher.doFinal(Base64.decodeBase64(encryptedText.getBytes("UTF-8"))),"UTF-8");
		}catch(Exception e) {
			plainText = "";
			e.printStackTrace();
			}
		return plainText;
	}
}
