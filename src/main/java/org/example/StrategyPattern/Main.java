package org.example.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        String originalText = "Hi this is a plain text";

        EncryptionStrategy strategy = new CaesarStrategy();
        StrategyContext context = new StrategyContext(strategy);

        byte[] encrypted = context.encryptText(originalText);
        String decrypted = context.decryptText(encrypted);

        String temp = new String(encrypted);

        System.out.println("Caesar Algorithm");
        System.out.println("Original text: " + originalText);
        System.out.println("Encrypted text: " + temp);
        System.out.println("Decrypted text:: " + decrypted);

        System.out.println();

        strategy = new AESStrategy();
        context.setStrategy(strategy);

        encrypted = context.encryptText(originalText);
        decrypted = context.decryptText(encrypted);

        temp = new String(encrypted);

        System.out.println("AES Algorithm");
        System.out.println("Original text: " + originalText);
        System.out.println("Encrypted text: " + temp);
        System.out.println("Decrypted text: " + decrypted);
    }
}
