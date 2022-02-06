package problems;

public class SearchInsertPosition {
    //35
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,6};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}

/*
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
 */