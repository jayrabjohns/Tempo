package tempo.backend;

import org.junit.jupiter.api.Test;
import main.backend.PasswordEncryption;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordEncryptionTest {

    // Use a pre-determined salt
    public String[] salts = {
        "EhriHSffB8XrgxI8LRGClb8tt",
        "EhriHSffB8XrgxI8LRGClb8tq", 
        "K5s7HJKhkbaHGK678HKJghsdp"
    };

    public String[][] passwords = {
        {"", "$1$EhriHSffB8XrgxI8LRGClb8tt2Z5m8XyxAkiJ3HNDgCDAJyJrogGGu/AkRcuNsUV12k8="},
        {"hello", "$1$EhriHSffB8XrgxI8LRGClb8ttZseiKukpHeHWe3wE7lLNiLS7YoqYiQQUhOUBN1trAAM="},
        {"$1$1$1$1$1", "$1$EhriHSffB8XrgxI8LRGClb8ttblnNE1CXlyONUPfQMDkSfJ105uGYnJZyq3UOAGT9Qwg="},
        {"1$1$1$1$1$", "$1$EhriHSffB8XrgxI8LRGClb8ttMDes6LZK+LzI/8b2RfKHQjf0ODuWflOCvJqWXllj19Y="},
        {"this is a really long password that you would never use because you would likely forget it", "$1$EhriHSffB8XrgxI8LRGClb8tt9T9LfKA/d9AxPlITtAg5eQwc8T2NcP0c226+KmFQgRE="},
        {"!$^%GJH£87", "$1$EhriHSffB8XrgxI8LRGClb8tt7VaSzdrk9LMyb9byuihi5GP1reYJvaZ4r5OTkeYkKlQ="},
    };

    @Test
    public void testEncryption() {
        PasswordEncryption hasher = new PasswordEncryption();

        for(String[] pair: this.passwords) {
            assertTrue(pair[1].equals(hasher.encryptPassword(pair[0], salts[0])));
        }
    }

    @Test
    public void testDuplication() {
        PasswordEncryption hasher = new PasswordEncryption();

        for(String[] pair: this.passwords) {

            String[] hashes = new String[salts.length];

            for(int i = 0; i < salts.length; i++) {

                String newHash = hasher.encryptPassword(pair[0], salts[i]);

                // Test none matching
                for(String hash: hashes) {
                    if (hash == null) {
                        continue;
                    }

                    assertFalse(hash.equals(newHash));
                }

                hashes[i] = newHash;
            }
        }
    }

    @Test
    public void testVerification() {
        PasswordEncryption hasher = new PasswordEncryption();

        for(String[] pair: this.passwords) {

            for(String[] test_pair: this.passwords) {

                assertEquals(test_pair[0] == pair[0], hasher.verifyPassword(pair[1], test_pair[0]), "Failed for " + test_pair[0] + " " + pair[0]);

            }

        }
    }
}
