import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Helper {

    /**
     * Takes a String parameter and hashes into SHA-256
     *
     * @param data String that is going to be hashed.
     * @return 64 character long and 256 byte string.
     */
    public static String generateHash(String data) {
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

            // Turning into hexadecimal values instead of bytes
            StringBuilder hexadecimalString = new StringBuilder();

            for (int i = 0; i < hash.length; i++){
                String hexadecimal = Integer.toHexString(0xff & hash[i]);

                // Padding that guarantees that every hash is 64 characters long.
                if(hexadecimal.length() == 1) hexadecimalString.append("0");
                hexadecimalString.append(hexadecimal);
            }

            return hexadecimalString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
