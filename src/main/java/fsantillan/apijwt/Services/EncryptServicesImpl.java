package fsantillan.apijwt.Services;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptServicesImpl implements EncryptServices {
    
    @Value("${key.vector}")
    private  String KEY;

    @Value("${iv.vector}")
    private  String INIT_VECTOR;

    @Override
    public String encryptText(String text) {
       try {
        boolean isEmpty = text.isBlank();
        if (isEmpty) throw new IllegalArgumentException("Error cadena vacia");
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrio un error durante el proceso de Encriptar el TEXTO: ".concat(ex.getMessage()));
        }
    }

    @Override
    public String decryptText(String text) {
        try {
            boolean isEmpty = text.isBlank();
            if (isEmpty) throw new IllegalArgumentException("Error cadena vacia");
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(text));

            return new String(original);
        } catch (Exception ex) {
            // throw new RuntimeException(ex.getMessage() "Ocurrio un error durante el proceso de DESENCRIPTAR el TEXTO", ex.getCause());
            throw new RuntimeException("Ocurrio un error durante el proceso de DESENCRIPTAR el TEXTO: ".concat(ex.getMessage()));
        }
    }

}
