package problems;

public class LengthOfLastWord {
    //58
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("gfjhg djk djshfjskh"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
