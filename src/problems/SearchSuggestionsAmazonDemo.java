package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
;
import static java.util.stream.Collectors.toList;

public class SearchSuggestionsAmazonDemo {

    public static void main(String[] args) {
        List<String> repository = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        String customerQuery = "mouse";

        List<List<String>> result = searchSuggestions(repository, customerQuery);
        for (List<String> strings : result) {
            System.out.println(strings);
        }
    }


    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i < customerQuery.length(); i++) {
            String s = customerQuery.substring(0, i + 1).toLowerCase();
            List<String> keywordsList = repository.stream()
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith(s))
                    .sorted()
                    .limit(3)
                    .collect(toList());
            res.add(keywordsList);
        }
        return res;
    }
}
