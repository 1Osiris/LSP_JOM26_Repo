package org.howard.edu.lsp.finalexam.question2;

/**
 * Implementation of random number generation using the Linear Congruential method.
 * Formula: X(n+1) = (aX(n) + c) mod m
 */
public class LinearCongruentialGenerator implements RandomNumberGenerator {
    private long seed;
    private final long a = 1664525;
    private final long c = 1013904223;
    private final long m = (long) Math.pow(2, 32);
    
    public LinearCongruentialGenerator() {
        this.seed = System.currentTimeMillis();
    }
    
    @Override
    public int generateNumber() {
        seed = (a * seed + c) % m;
        return Math.abs((int) seed) + 1;
    }
}
