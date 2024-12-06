package org.howard.edu.lsp.finalexam.question2;

/**
 * Client program to demonstrate the RandomNumberService.
 */
public class RandomNumberClient {
    public static void main(String[] args) {
        RandomNumberService service = RandomNumberService.getInstance();
        
        System.out.println("Using Java Random Generator:");
        service.setGenerator(new JavaRandomGenerator());
        for (int i = 0; i < 5; i++) {
            System.out.println("Random number " + (i + 1) + ": " + 
                service.getRandomNumber());
        }
        
        System.out.println("\nUsing Linear Congruential Generator:");
        service.setGenerator(new LinearCongruentialGenerator());
        for (int i = 0; i < 5; i++) {
            System.out.println("Random number " + (i + 1) + ": " + 
                service.getRandomNumber());
        }
    }
}
