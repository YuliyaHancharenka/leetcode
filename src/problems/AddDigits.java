package problems;

public class AddDigits {
    //258
    public static void main(String[] args) {
        System.out.println(addDigitsFormula(56));
    }

    /*
    The value we're asked to compute is the so-called Digital Root.
    Logarithmic time solution is easy to write, although the main question here is how to fit into a constant time.
     */
    private static int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;

            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;
            }
        }
        return digitalRoot;
    }

    //Mathematical: Digital Root
    private static int addDigitsFormula(int num) {
        if (num==0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
