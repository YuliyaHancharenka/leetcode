package problems;

public class NumbersInSequence {
    //Please print numbers in following sequence: 0, 1, -1, 2, -2, 3, -3, 4, -4, 5, -5

    public static void main(String[] args) {
        for (int i = 0; i < 6; i ++) {
            if (i == 0) {
                System.out.println(0);
            } else {
                System.out.println(i * 1);
                System.out.println(i * -1);
            }
        }
    }
}
