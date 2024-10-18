public class Calculator {
    
    /**
     * Calculates the sum of two integers.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public static int sum(int a, int b) {
        return a + b;
    }

    /**
     * Calculates the sum of two double values.
     *
     * @param a the first double value
     * @param b the second double value
     * @return the sum of a and b
     */
    public static double sum(double a, double b) {
        return a + b;
    }


    /**
     * Calculates the sum of all integers in an array.
     *
     * @param numbers the array of integers to sum
     * @return the sum of all elements in the array
     */
    public static int sum(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}
