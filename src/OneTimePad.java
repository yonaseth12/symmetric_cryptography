public class OneTimePad {
    // OTP Encryption Method
    public static byte[] otpEncrypt(byte[] message, byte[] key) {
        //Checking precondition: Equality of length of key with length of message
        if (message.length != key.length) {
            return "Wrong Operation: Message and key must have the same length".getBytes();
        }
        byte[] cipherText = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            cipherText[i] = (byte) (message[i] ^ key[i]);
        }
        return cipherText;
    }

    // OTP Decryption Method
    public static byte[] otpDecrypt(byte[] cipherText, byte[] key) {
        //Decryption has the same implementation as encryption
        return otpEncrypt(cipherText, key);
    }
}
