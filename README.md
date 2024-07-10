# Puzzles-ProductArrayExceptSelf

Generate the product of elements of an input array where each element is excluded from its product.

## Problem Description

This is the classic Amazon interview question.

The input into the problem is an array of n numbers.

The output is a return array of the same size.

Each spot in the return array is the product of elements
excluding the value at the same location of the input array.

For example, when the input array is

`[1, 2, 3, 4]`

then in the output array,

```
position 0 is 2*3*4 = 24
position 1 is 1*3*4 = 12
position 2 is 1*2*4 = 8
position 3 is 1*2*3 = 6
```

making:

`[24, 12, 8, 6]`

The solution requires a left and right product array.

The left array represents all the multiplications to the left.

We seed the first location with the value `1`.

From position 1, the multiplication of all of the stuff to the left is `1`.

From position 2, the multiplication of all of the stuff to the left is `1*2 = 2`.

From position 3, the multiplication of all of the stuff to the left is `1*2*3 = 6`.

The left array is thus:

`[1, 1, 2, 6]`

The right array represents all the multiplications to the right.

We see the last location with the value `1`.

From position 0, the multiplication of all of the stuff to the right is `2*3*4 = 24`.

From position 1, the multiplication of all of the stuff to the right is `3*4 = 12`.

From position 2, the multiplication of all of the stuff to the right is `4`.

The right array is thus:

`[24, 12, 4, 1]`

The merged product array is the multiplication of same position of left and right values.

```
[1*24, 1*12, 2*4, 6*1] = [24, 12, 8, 6]
```

This is the desired result.

## Personal Note

This is a solution that does not jump out at me as obvious.

I would have not picked this immediately in a code test.

The timer would run out on me as I use trial and error to MacGyver something.

## Observation

I was contemplating why a left/right strategy is used.

I think it is a divide-and-conquer strategy.

Intuitively, we want the product of values to the left and right of the current position,
and the product of values excludes the value of the current position.

Therefore, programmatically, it makes senses to accumulate all product values to the left of the current position,
then accumulate all the product values to the right of the current position.

We iterate over the current position.

Then we aggregate them by multiplying values at the same position.
