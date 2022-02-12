package problems;

import java.util.Arrays;

public class PermutationInString {
    //567
    public static void main(String[] args) {
        System.out.println(checkInclusionSlidingWindow("ab", "eidbaooo"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    private static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    //the clearest solution
    private static boolean checkInclusionUsingSorting(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }

    private static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

    /*Approach #5
    Sliding Window [Accepted]:
Algorithm
Instead of generating the hashmap afresh for every window considered in s2, we can create the hashmap just once for the first window in s2.
Then, later on when we slide the window, we know that we remove one preceding character and add a new succeeding character to the new window considered.
Thus, we can update the hashmap by just updating the indices associated with those two characters only.
Again, for every updated hashmap, we compare all the elements of the hashmap for equality to get the required result.
     */
    private static boolean checkInclusionSlidingWindow(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)) return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    /*
Approach #6 Optimized Sliding Window [Accepted]:
Algorithm

The last approach can be optimized, if instead of comparing all the elements of the hashmaps for every updated s2map corresponding to every window of s2
considered, we keep a track of the number of elements which were already matching in the earlier hashmap and update just the count of matching elements
when we shift the window towards the right.

To do so, we maintain a countcount variable, which stores the number of characters(out of the 26 alphabets),
which have the same frequency of occurence in s1s1 and the current window in s2s2. When we slide the window,
if the deduction of the last element and the addition of the new element leads to a new frequency match of any of the characters,
we increment the countcount by 1. If not, we keep the countcount intact.
But, if a character whose frequency was the same earlier(prior to addition and removal) is added, it now leads to a frequency mismatch
which is taken into account by decrementing the same countcount variable. If, after the shifting of the window, the countcount evaluates to 26,
it means all the characters match in frequency totally.
 So, we return a True in that case immediately.
     */
//todo unclear
    private static boolean checkInclusionSlidingWindowOptimized(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }
}

/*
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 */