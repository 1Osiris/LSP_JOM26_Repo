package org.howard.edu.lsp.finalexam.question2;

import java.util.Random;

/**
 * Implementation of random number generation using Java's built-in Random class.
 */
public class JavaRandomGenerator implements RandomNumberGenerator {
    private final Random random;
    
    public JavaRandomGenerator() {
        this.random = new Random();
    }
    
    @Override
    public int generateNumber() {
        return Math.abs(random.nextInt()) + 1;
    }
}
