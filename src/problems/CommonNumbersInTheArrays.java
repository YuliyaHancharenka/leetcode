package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersInTheArrays {
    //Put all common values from arrays into the new array.
    //The result should be a previously created array with values: [4, 5, 6]

        public static void main(String[] args) {
            int[] a = {1, 2, 3, 4, 5, 6};
            int[] b = {3, 4, 5, 6, 7, 8};
            int[] c = {1, 5, 6, 4, 9, 0};

          //  int[] commonAandB = findCommonElement(a, b);
          //  System.out.println(Arrays.toString(findCommonElement2(c, a, b)));
            findCommonElement3(c, a, b);
        }

    public static int[] findCommonElement(int[] a, int[] b) {
        List<Integer> commonElements = new ArrayList<>();
        for (int i : a) {
            for (int j : b) {
                if (i == j) {
                    if (!commonElements.contains(i)) {
                        commonElements.add(i);
                    }
                }
            }
        }
        return commonElements.stream().mapToInt(i -> i).toArray();
    }

    public static int[] findCommonElement2(int[] a, int[] b, int[] c) {
        List<Integer> commonElements = new ArrayList<>();
        for (int i : a) {
            for (int j : b) {
                for (int k : c) {
                    if (i == j && j == k) {
                        if (!commonElements.contains(i)) {
                            commonElements.add(i);
                        }
                    }
                }
            }
        }
        return commonElements.stream().mapToInt(i -> i).sorted().toArray();
    }

    public static void findCommonElement3 (int[] a, int[] b, int[] c) {
        int[] array = new int[a.length];
        int commonNumberCount = 0;

        for(int i = 0; i < a.length; i++) {
            for(int z = 0; z < a.length; z++) {
                for(int x = 0; x < a.length; x++) {
                    if (a[i] == b[z] && b[z] == c[x]) {
                        array[i] = a[i];
                        commonNumberCount++;
                    }
                }
            }
        }
        int[] commonNumberArray = new int[commonNumberCount];
        int index = 0;

        for (int j : array) {
            if (j > 0) {
                commonNumberArray[index] = j;
                index++;
            }
        }
        System.out.println(Arrays.toString(commonNumberArray));
    }
}
