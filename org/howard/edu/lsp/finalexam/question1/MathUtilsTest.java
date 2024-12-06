package org.howard.edu.lsp.finalexam.question1

import org.junit.Test;
import static org.junit.Assert.*;
import junit.Before;

public class MathUtilsTest {
    private MathUtils mathUtils;
    
    @Before
    public void setUp() {
        mathUtils = new MathUtils();
    }
    
    // Factorial Tests
    @Test
    public void testFactorial_ZeroInput_ReturnsOne() {
        assertEquals(1, mathUtils.factorial(0));
    }
    
    @Test
    public void testFactorial_OneInput_ReturnsOne() {
        assertEquals(1, mathUtils.factorial(1));
    }
    
    @Test
    public void testFactorial_PositiveInput_ReturnsCorrectResult() {
        assertEquals(120, mathUtils.factorial(5));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_NegativeInput_ThrowsException() {
        mathUtils.factorial(-1);
    }
    
    // Prime Number Tests
    @Test
    public void testIsPrime_PrimeNumber_ReturnsTrue() {
        assertTrue(mathUtils.isPrime(17));
    }
    
    @Test
    public void testIsPrime_NonPrimeNumber_ReturnsFalse() {
        assertFalse(mathUtils.isPrime(15));
    }
    
    @Test
    public void testIsPrime_One_ReturnsFalse() {
        assertFalse(mathUtils.isPrime(1));
    }
    
    // GCD Tests
    @Test
    public void testGcd_PositiveNumbers_ReturnsCorrectResult() {
        assertEquals(6, mathUtils.gcd(24, 30));
    }
    
    @Test
    public void testGcd_OneZeroInput_ReturnsNonZeroInput() {
        assertEquals(15, mathUtils.gcd(0, 15));
        assertEquals(15, mathUtils.gcd(15, 0));
    }
    
    @Test
    public void testGcd_NegativeNumbers_ReturnsPositiveResult() {
        assertEquals(4, mathUtils.gcd(-12, -16));
    }
    
    @Test
    public void testGcd_OneNegativeOnePositive_ReturnsPositiveResult() {
        assertEquals(5, mathUtils.gcd(-25, 15));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGcd_BothZeroInputs_ThrowsException() {
        mathUtils.gcd(0, 0);
    }
}
