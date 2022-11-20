package problems;

import java.util.*;

public class ReverseTheList {
    //Get the list of even numbers in reverse order and print it

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //Collections.reverse(ints);

        List<Integer> reversed = new ArrayList<>();
        for( int i = ints.size()-1; i >= 0; i--){
            int element = ints.get(i);
            reversed.add(element);
        }

        List<Integer> intsEven = new ArrayList<>();
        for (Integer i : reversed) {
            if (i % 2 == 0) {
                intsEven.add(i);
            }
        }
        System.out.println(intsEven);
    }
}
