import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class TripleDES {
    //3DES Encryption Method
    public static byte[] desEncrypt(String plaintext, String keyString) throws Exception {
        byte[] keyBytes = keyString.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] plaintextBytes = plaintext.getBytes();
        return cipher.doFinal(plaintextBytes);
    }

    //3DES Decryption Method
    public static String desDecrypt(byte[] ciphertext, String keyString) throws Exception {
        byte[] keyBytes = keyString.getBytes();
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes);
    }
}
