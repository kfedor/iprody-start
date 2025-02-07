package lesson23;

import lesson23.annotations.AfterSuite;
import lesson23.annotations.BeforeSuite;
import lesson23.annotations.Test;
import lesson23.util.MathUtil;

public class TestClass {

    @BeforeSuite
    public void printSomeInfoBefore() {
        System.out.println("Start testing...");
    }

    @Test(order = 1)
    public void shouldMultiplyTwoPositiveValues() {
        if (MathUtil.multiply(10, 10) == 100) {
            System.out.println("shouldSumTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSumTwoGivenPositiveValues failed");
        }
    }

    @Test(order = 2)
    public void shouldSumTwoGivenPositiveValues() {
        if (MathUtil.sum(10, 11) == 21) {
            System.out.println("shouldSumTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSumTwoGivenPositiveValues failed");
        }
    }

    @Test(order = 3)
    public void shouldMultiplyTwoNegativeValues() {
        if (MathUtil.multiply(-10, -10) == 100) {
            System.out.println("shouldSumTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSumTwoGivenPositiveValues failed");
        }
    }

    @Test(order = 3)
    public void shouldMultiplyWithZero() {
        if (MathUtil.multiply(10, 0) == 100) {
            System.out.println("shouldSumTwoGivenPositiveValues passed");
        } else {
            System.out.println("shouldSumTwoGivenPositiveValues failed");
        }
    }

    @AfterSuite
    public void printSomeInfoAfter() {
        System.out.println("End testing...");
    }
}
