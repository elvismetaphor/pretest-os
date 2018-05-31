package me.elvismetaphor.question;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class NextFibonacciGeneratorTest {

    @Parameterized.Parameters
    public static List<Object []> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{2, 13, 34, 13}, new int[]{1, 9, 22, 11}},
                {new int[]{89, 55, 13, 34}, new int[]{81, 40, 11, 33}},
                {new int[]{144, 8, 13, 3, 55}, new int[]{100, 7, 10, 2, 50}},
                {new int[]{2, 2, 13, 13}, new int[]{1, 1, 8, 8}}
        });
    }

    private int[] expectation;
    private int[] input;

    public NextFibonacciGeneratorTest(int[] expectation, int[] input) {
        this.expectation = expectation;
        this.input = input;
    }

    @Test
    public void When_InputIsEmpty_Should_ReturnEmpty() {
        // Arrange
        NextFibonacciGenerator testee = createGenerator();
        int[] input = new int[0];

        // Action
        int[] result = testee.generateNextFibonacciNumbers(input);

        // Assert
        Assert.assertEquals(0, result.length);
    }

    @Test
    public void When_InputWithValues_Should_ReturnNextFibonacciNumber() {
        // Arrange
        NextFibonacciGenerator testee = createGenerator();

        // Action
        int[] result = testee.generateNextFibonacciNumbers(input);

        // Assert
        Assert.assertArrayEquals(expectation, result);
    }

    private NextFibonacciGenerator createGenerator() {
        return new NextFibonacciGenerator();
    }
}