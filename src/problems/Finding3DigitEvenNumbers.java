package problems;

import java.util.ArrayList;
import java.util.List;

public class Finding3DigitEvenNumbers {
    //2094 //todo not clear

    public static void main(String[] args) {
        int[] digits = new int[]{2, 1, 3, 0};
        int[] result = findEvenNumbers(digits);
        for (int i = 0; i < result.length - 1; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] findEvenNumbers(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[10];

        for (final int digit : digits)
            ++count[digit];

        // try to construct `abc`
        for (int a = 1; a <= 9; ++a)
            for (int b = 0; b <= 9; ++b)
                for (int c = 0; c <= 8; c += 2)
                    if (count[a] > 0 && count[b] > (b == a ? 1 : 0) && count[c] > (c == a ? 1 : 0) + (c == b ? 1 : 0))
                        ans.add(a * 100 + b * 10 + c);

        return ans.stream().mapToInt(i -> i).toArray();
    }
}

/*
Example 1:
Input: digits = [2,1,3,0]
Output: [102,120,130,132,210,230,302,310,312,320]
Explanation: All the possible integers that follow the requirements are in the output array.
Notice that there are no odd integers or integers with leading zeros.

Example 2:
Input: digits = [3,7,5]
Output: []
Explanation: No even integers can be formed using the given digits.
 */