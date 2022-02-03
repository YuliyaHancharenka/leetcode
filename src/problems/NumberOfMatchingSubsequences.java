package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    //792
    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq(S, words));
    }

    public static int numMatchingSubseq(String S, String[] words) {
        int ret = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }

        for (String word : words) {
            if (match(S, word, map, 0)) {
                ret++;
            }
        }
        return ret;
    }

    private static boolean match(String S, String word, Map<Character, List<Integer>> map, int startIndex) {
        if (word.length() == 0) return true;
        if (!map.containsKey(word.charAt(0))) return false;
        for (int start : map.get(word.charAt(0))) {
            if (start < startIndex) continue;
            String newWord = word.substring(1);
            return match(S, newWord, map, start + 1);
        }

        return false;
    }

}

/*
Example 1:
Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".

Example 2:
Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 */