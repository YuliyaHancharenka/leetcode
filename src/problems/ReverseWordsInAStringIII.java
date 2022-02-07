package problems;

public class ReverseWordsInAStringIII {
    //557
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    /*
    Approach #1 Simple Solution[Accepted]
The first method is really simple. We simply split up the given string based on whitespaces and put the individual words in an array of strings.
Then, we reverse each individual string and concatenate the result. We return the result after removing the additional whitespaces at the end.
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString()).append(" ");
        return res.toString().trim();
    }
}

/*
Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

 */