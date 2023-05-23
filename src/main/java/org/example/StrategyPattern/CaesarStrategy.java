package org.example.StrategyPattern;

import java.util.Random;

public class CaesarStrategy implements EncryptionStrategy{

    private static String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.-";
    private int shift;

    public byte[] encrypt(String text) {
        StringBuilder encryptText = new StringBuilder();
        for (int index = 0; index < text.length(); index++) {
            int charPosition = ALPHABET.indexOf(text.charAt(index));
            int newCharPosition = (shift + charPosition) % ALPHABET.length();
            char newCharacter = ALPHABET.charAt(newCharPosition);
            encryptText.append(newCharacter);
        }
        byte[] result = encryptText.toString().getBytes();
        return result;
    }

    public String decrypt(byte[] textToDecrypt) {
        String encryptedText = new String(textToDecrypt);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < encryptedText.length(); index++) {
            int alphabetPosition = ALPHABET.indexOf(encryptedText.charAt(index));
            int newCharPosition = (alphabetPosition - shift) % ALPHABET.length();
            if(newCharPosition < 0)
                newCharPosition = ALPHABET.length() + newCharPosition;
            char newCharacter = ALPHABET.charAt(newCharPosition);
            result.append(newCharacter);
        }
        return result.toString();
    }

    public boolean init() {
        Random random = new Random();
        shift = random.nextInt(ALPHABET.length());
        return true;
    }
}
