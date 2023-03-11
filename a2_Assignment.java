import java.util.Scanner;
    //Program From https://github.com/shreyas5522/information-security/
public class a2_Assignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the plain text[Only String]:");
        String plaintext = input.nextLine();
        System.out.println("Enter the key:");
        int key = input.nextInt();
        input.nextLine(); // Consume the newline character

        // Encryption
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Encrypted text: " + ciphertext);

        // Decryption
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);

        input.close();
    }

    private static String encrypt(String plaintext, int key) {
        int rows = (int) Math.ceil((double) plaintext.length() / key);
        char[][] matrix = new char[rows][key];
        int index = 0;

        // Fill the matrix with plaintext characters
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key; j++) {
                if (index < plaintext.length()) {
                    matrix[i][j] = plaintext.charAt(index++);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // Read the characters from the matrix in column-major order
        StringBuilder ciphertext = new StringBuilder();
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < rows; i++) {
                ciphertext.append(matrix[i][j]);
            }
        }

        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext, int key) {
        int rows = (int) Math.ceil((double) ciphertext.length() / key);
        char[][] matrix = new char[rows][key];
        int index = 0;

        // Fill the matrix with ciphertext characters
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < rows; i++) {
                if (index < ciphertext.length()) {
                    matrix[i][j] = ciphertext.charAt(index++);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // Read the characters from the matrix in row-major order
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key; j++) {
                decryptedText.append(matrix[i][j]);
            }
        }

        return decryptedText.toString().trim();
    }
}
