package org.example.StrategyPattern;

public interface EncryptionStrategy {
    byte[] encrypt(String text);
    String decrypt(byte[] textToDecrypt);
    boolean init();
}
