package problems;

public class ValidAnagram {
    //242
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) return false;
        }
        return true;
    }
}

/*
The statement ++array[s.charAt(i) - 'A']; is incrementing the value in the array indexed by s.charAt(i) - 'A'.
What this loop does is that it counts up the number of occurrences of each letter in s.
The reason for - 'A', is that it "shifts" the ascii/unicode value so that A - Z have values 0 - 25. And are thus more suitable as an array index.
 */

/*
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 */