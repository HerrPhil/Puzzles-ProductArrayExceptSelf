import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class ProductArrayExceptSelf {

    public static void main(String [] args) {
        System.out.printf("Hello Product of Array Except Self Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java ProductArrayExceptSelf%n");
            return;
        }

        ProductArrayExceptSelf product = new ProductArrayExceptSelf();

        int[] input = new int[] {1, 2, 3, 4};

        int position = 0;
        for (int value : input) {
            System.out.printf("input position of %d is %d%n", position++, value);
        }

        int[] output = product.multiplyExceptSelf(input);

        position = 0;
        for (int value : output) {
            System.out.printf("output position of %d is %d%n", position++, value);
        }
    }

    public int[] multiplyExceptSelf(int[] input) {
        int n = input.length;

        int[] left = new int [n];
        int[] right = new int [n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Find the product values to the left of the current position.
        // This uses a small amount of dynamic programming,
        // by accumulating the product of values.
        int leftMultiplied = 1;
        int rightMultiplied = 1;
        System.out.printf("Figure out all of the product values of values to the left of current positions%n");
        for (int i = 0; i < n - 1; i++) {
            leftMultiplied *= input[i];
            rightMultiplied *= input[n - i - 1];
            System.out.printf("product of values to the left of position %d is %d%n", i + 1, leftMultiplied);
            System.out.printf("product of values to the right of position %d is %d%n", n - i - 2, rightMultiplied);
            left[i + 1] = leftMultiplied;
            right[n - i - 2] = rightMultiplied;
        }

        int position = 0;
        for (int value : left) {
            System.out.printf("left output of %d is %d%n", position++, value);
        }

        position = 0;
        for (int value : right) {
            System.out.printf("right output of %d is %d%n", position++, value);
        }

        int[] result = new int [input.length];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

}
