package org.howard.edu.lsp.finalexam.question2;

/**
 * Singleton service for generating random numbers using different strategies.
 */
public class RandomNumberService {
    private static RandomNumberService instance;
    private RandomNumberGenerator generator;
    
    private RandomNumberService() {
        // Private constructor for singleton
        this.generator = new JavaRandomGenerator(); // Default strategy
    }
    
    /**
     * Gets the singleton instance of the service.
     * @return the singleton instance
     */
    public static synchronized RandomNumberService getInstance() {
        if (instance == null) {
            instance = new RandomNumberService();
        }
        return instance;
    }
    
    /**
     * Sets the random number generation strategy.
     * @param generator the strategy to use
     */
    public void setGenerator(RandomNumberGenerator generator) {
        this.generator = generator;
    }
    
    /**
     * Generates a random number using the current strategy.
     * @return a positive random integer
     */
    public int getRandomNumber() {
        return generator.generateNumber();
    }
}
