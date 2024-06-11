package fsantillan.apijwt.Services;

public interface EncryptServices {
    String encryptText(String text);
    String decryptText(String encrypted);
}
