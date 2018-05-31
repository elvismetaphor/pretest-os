package me.elvismetaphor.question;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubsetCheckerTest {

    @Test
    public void When_BothEmpty_Should_ReturnTrue() {
        // Arrange
        SubsetChecker testee = createSubsetChecker();
        char[] first = {};
        char[] second = {};

        // Action
        boolean result = testee.isSubset(first, second);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void When_SecondIsASubsetOfFirst_Should_ReturnTrue() {
        // Arrange
        SubsetChecker testee = createSubsetChecker();
        char[] first = {'A', 'B', 'C', 'D', 'E'};
        char[] second = {'A', 'E', 'D', 'A'};

        // Action
        boolean result = testee.isSubset(first, second);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void When_SecondIsNotASubsetOfFirst_Should_ReturnFalse() {
        // Arrange
        SubsetChecker testee = createSubsetChecker();
        char[] first = {'A', 'B', 'C', 'D', 'E'};
        char[] second = {'Z', 'A', 'D'};

        // Action
        boolean result = testee.isSubset(first, second);

        // Assert
        Assert.assertFalse(result);
    }

    private SubsetChecker createSubsetChecker() {
        return new SubsetChecker();
    }
}