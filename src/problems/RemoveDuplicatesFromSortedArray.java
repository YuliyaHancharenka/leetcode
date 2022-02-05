package problems;

public class RemoveDuplicatesFromSortedArray {
    //26
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 77, 2, 3, 4, 4, 4, 5, 5};

        int n = removeDuplicates(nums);

        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + " ");
    }
}

/*
Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */