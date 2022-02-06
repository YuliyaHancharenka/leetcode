package problems;

import java.util.Arrays;

public class SquaresOfASortedArray {
    //977
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] sortedSquaresNums = sortedSquares(nums);
        for (int sortedSquaresNum : sortedSquaresNums) {
            System.out.println(sortedSquaresNum);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int[] sortedSquaresNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedSquaresNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(sortedSquaresNums);
        return sortedSquaresNums;
    }

    /*
    Approach 2: Two Pointer
Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order,
then some non-negative elements with squares in increasing order.

For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1], and the positive part [4, 5, 6] with squares [16, 25, 36].
Our strategy is to iterate over the negative part in reverse, and the positive part in the forward direction.

Algorithm
We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction, and another i in the negative direction.
Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a two-pointer technique.
     */
    public static int[] sortedSquaresTwoPointers(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}

/*
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */