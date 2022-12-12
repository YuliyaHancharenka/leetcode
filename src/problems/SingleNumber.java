package problems;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    //136

    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        List<Integer> noDuplicateList = new ArrayList<>();

        for (int i : nums) {
            if (!noDuplicateList.contains(i)) {
                noDuplicateList.add(i);
            } else {
                noDuplicateList.remove(new Integer(i));
            }
        }
        return noDuplicateList.get(0);
    }
}
