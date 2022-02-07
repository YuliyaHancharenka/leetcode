package problems;

public class RotateArray {
    //189
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateUsingExtraArray(nums, k);
    }

    /*
    Approach 1: Brute Force
    The simplest approach is to rotate all the elements of the array in kk steps by rotating the elements by 1 unit in each step.
     */

    public static void rotate(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /*
    Approach 2: Using Extra Array
Algorithm
We use an extra array in which we place every element of the array at its correct position
i.e. the number at index ii in the original array is placed at the index (i + k) \% \text{ length of array}(i+k)% length of array.
Then, we copy the new array to the original one.
*/

    public static void rotateUsingExtraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


/*
Approach 4: Using Reverse
Algorithm
This approach is based on the fact that when we rotate the array k times,
k%n k elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.

In this approach, we firstly reverse all the elements of the array.
Then, reversing the first k elements followed by reversing the rest n-kn−k elements gives us the required result.
Let n = 7n=7 and k = 3k=3.

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
 */

    public void rotateUsingReverseMain(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}





/*
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */