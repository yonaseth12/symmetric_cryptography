import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    //AES Encryption Method
    public static byte[] aesEncrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(key);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(data);
    }

    //AES Decryption Method
    public static byte[] aesDecrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKey secretKey = new SecretKeySpec(key, "AES");
        IvParameterSpec iv = new IvParameterSpec(key);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(data);
    }
}
