package me.elvismetaphor.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextFibonacciGenerator {

    public void nextFibonacci(int[] input) {
        int[] results = generateNextFibonacciNumbers(input);
        for (int num : results) {
            System.out.println(num);
        }
    }

    int[] generateNextFibonacciNumbers(int[] input) {
        List<Integer> fibs = generateFibonacciNumbersOverTarget(getLargestNumber(input));

        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = getNextFibonacciNumber(fibs, input[i]);
        }
        return result;
    }

    private List<Integer> generateFibonacciNumbersOverTarget(int target) {
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 1));
        if (target < 1) {
            return result;
        }

        for (int i = 2;; i++) {
            int current = result.get(i - 1) + result.get(i - 2);
            result.add(current);

            if (current > target) {
                return result;
            }
        }
    }

    private int getLargestNumber(int[] input) {
        int largestNumber = Integer.MIN_VALUE;
        for (int number : input) {
            if (number > largestNumber) {
                largestNumber = number;
            }
        }

        return largestNumber;
    }

    private int getNextFibonacciNumber(List<Integer> fibs, int target) {
        for (int fib : fibs) {
            if (fib > target) {
                return fib;
            }
        }

        throw new IllegalArgumentException(
                "The target shouldn't be bigger than all generated fibonacci numbers"
        );
    }
}
