package problems;

public class ReverseString {
    //344
    public static void main(String[] args) {
        //char[] s = new char[]{"h", "e", "l", "l", "o"};
        String input = "Geeks For Geeks";
        reverseStringWithArray(input);
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public static void reverseStringWithArray(String input) {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        for (char c : temparray)
            System.out.print(c);
        System.out.println();
    }
}
/*
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 */