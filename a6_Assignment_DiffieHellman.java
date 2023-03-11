import java.util.Scanner;

//Program From https://github.com/shreyas5522/information-security/

class a6_Assignment_DiffieHellman {
    public static void main(String[] args) {
        // Get input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter modulo(p) [Integer]: ");
        int p = sc.nextInt();
        System.out.println("Enter primitive root of  [Integer]: " + p);
        int g = sc.nextInt();
        System.out.println("Enter 1st secret number (Alice)");
        int a = sc.nextInt();
        System.out.println("Enter 2nd secret number (Bob)");
        int b = sc.nextInt();

        // Calculate public keys
        int A = (int) Math.pow(g, a) % p;
        int B = (int) Math.pow(g, b) % p;

        // Calculate shared secret
        int S_A = (int) Math.pow(B, a) % p;
        int S_B = (int) Math.pow(A, b) % p;

        // Check if both parties can communicate
        if (S_A == S_B) {
            System.out.println("Alice and Bob can communicate with each other!");
            System.out.println("They share a secret number = " + S_A);
        } else {
            System.out.println("Alice and Bob cannot communicate with each other.");
        }
    }
}
