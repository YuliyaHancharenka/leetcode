package problems;

public class MaximumAverageSubarrayI {
    //643
    public static void main(String[] args) {
        int[] nums = new int[] {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        double result = sum[k - 1] * 1.0 / k;
        for (int i = k; i < nums.length; i++) {
            result = Math.max(result, (sum[i] - sum[i - k]) * 1.0 / k);
        }
        return result;
    }
}

/*
        Example 1:
        Input: nums = [1,12,-5,-6,50,3], k = 4
        Output: 12.75000
        Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

        Example 2:
        Input: nums = [5], k = 1
        Output: 5.00000
 */