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
            System.out.printf("input of %d is %d%n", position++, value);
        }

        int[] output = product.multiplyExceptSelf(input);

        position = 0;
        for (int value : output) {
            System.out.printf("output of %d is %d%n", position++, value);
        }
    }

    public int[] multiplyExceptSelf(int[] input) {
        int[] result = new int [input.length];
        Arrays.fill(result, 1);
        int n = input.length;

        // Find the product values to the left of the current position.
        // This uses a small amount of dynamic programming,
        // by accumulating the product of values.
        int leftMultiplied = 1;
        System.out.printf("Figure out all of the product values of values to the left of current positions%n");
        for (int i = 0; i < n - 1; i++) {
            leftMultiplied *= input[i];
            System.out.printf("up to position %d the total product is %d%n", i, leftMultiplied);
        }
        return result;
    }

}
