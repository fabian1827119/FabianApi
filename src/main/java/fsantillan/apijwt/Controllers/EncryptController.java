package fsantillan.apijwt.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fsantillan.apijwt.Services.EncryptServices;

@RestController
@RequestMapping(value = "/api/Encrypt")
public class EncryptController {

    @Autowired
    private final EncryptServices encryptServices;

    public EncryptController(EncryptServices encryptServices) {
        this.encryptServices = encryptServices;
    }

    @GetMapping(value = "/encrypt/{text}")
    public ResponseEntity<String> encrypt(@PathVariable String text) {
        String encrypted = encryptServices.encryptText(text);
        return ResponseEntity.ok(encrypted);
    }

    @GetMapping(value = "/decrypt/{text}")
    public ResponseEntity<String> decrypt(@PathVariable String text) {
        String decrypted = encryptServices.decryptText(text);
        return ResponseEntity.ok(decrypted);
    }

}
