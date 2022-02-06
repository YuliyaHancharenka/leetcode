package problems;

public class MoveZeroes {
    //283
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        int[] numsWoZeroes = moveZeroes(nums);
        for (int i : numsWoZeroes) {
            System.out.println(i);
        }
    }

    public static int[] moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements, all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}

/*
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */