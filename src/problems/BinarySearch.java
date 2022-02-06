package problems;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch {
    //704
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        Map<Integer, Integer> numSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numSet.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    /*
    Approach 1: Binary Search
Binary search is a textbook algorithm based on the idea to compare the target value to the middle element of the array.
If the target value is equal to the middle element - we're done.
If the target value is smaller - continue to search on the left.
If the target value is larger - continue to search on the right.
     */
    public static int search2(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}

/*
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
 */