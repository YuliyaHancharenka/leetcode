package problems;

import java.util.Comparator;

public class SecondLargestDigitInAString {
    //1796
    public static void main(String[] args) {
        String s = "dfa126321afd";
        System.out.println(secondHighest(s));
    }

    private static int secondHighest(String s) {
        char[] chArr = s.toCharArray();
        int st = -1, rd = -1;
        for (char ch : chArr) {
            if (!Character.isDigit(ch)) {
                continue;
            }
            int n = ch - '0';
            if (n > st) {
                rd = st;
                st = n;
            } else if (n > rd && n != st) {
                rd = n;
            }
        }
        return rd;
    }
}
/*
Example 1:
Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

Example 2:
Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit.
 */