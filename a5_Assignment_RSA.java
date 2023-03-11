import java.math.BigInteger;
import java.security.SecureRandom;

//Program From https://github.com/shreyas5522/information-security/

public class a5_Assignment_RSA {
    private BigInteger n, d, e;

    public a5_Assignment_RSA(int bitLength) {
        SecureRandom r = new SecureRandom();
        // Generate two distinct prime numbers p and q
        BigInteger p = new BigInteger(bitLength / 2, 100, r);
        BigInteger q = new BigInteger(bitLength / 2, 100, r);
        // Calculate n = p*q
        n = p.multiply(q);
        // Calculate z = (p-1)*(q-1)
        BigInteger z = p.subtract(BigInteger.ONE)
                        .multiply(q.subtract(BigInteger.ONE));
        // Select a random integer e such that 1 < e < z and gcd(e, z) = 1
        e = new BigInteger(bitLength / 2, 100, r);
        while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0) {
            e = e.add(BigInteger.ONE);
        }
        // Calculate d = e^-1 mod z
        d = e.modInverse(z);
    }

    // Encryption
    public byte[] encrypt(byte[] message) {
        BigInteger msg = new BigInteger(message);
        BigInteger c = msg.modPow(e, n);
        return c.toByteArray();
    }

    // Decryption
    public byte[] decrypt(byte[] message) {
        BigInteger c = new BigInteger(message);
        BigInteger msg = c.modPow(d, n);
        return msg.toByteArray();
    }

    public static void main(String[] args) {
        a5_Assignment_RSA rsa = new a5_Assignment_RSA(1024);
        String message = "Hello, World!";
        // Encryption
        byte[] encryptedMessage = rsa.encrypt(message.getBytes());
        // Decryption
        byte[] decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Original message: " + message);
        System.out.println("Encrypted message: " + new String(encryptedMessage));
        System.out.println("Decrypted message: " + new String(decryptedMessage));
    }
}
