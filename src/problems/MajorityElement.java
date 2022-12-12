package problems;

public class MajorityElement {

    //169
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }
}
