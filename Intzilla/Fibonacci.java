public class Fibonacci {

    public static void main(String[] args) {
        /*
        outputs the nth number in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...,
        that is, the sequence which begins with zero, then one,
        and then each succeeding number is the sum of the two immediately preceding it.
        The program's argument will be a single Java int;
        so, to determine the ten thousandth Fibonacci number, we would run the program like this:
        java Fibonacci 10000
        */
        if (args.length == 1) {
            try {
                int l = Integer.parseInt(args[0]);
                Intzilla i = fibonacci(l);
                System.out.println("Fibonnaci number of " + l + " is " + i);
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a positive integer");
            } catch (IllegalArgumentException eae) {
                System.out.println(eae.getMessage());
            }
        } else {
            System.out.println("Please input only one positive integer");
        }

    }

    public static Intzilla fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci of negative numbers can not be computed");
        }
        if (n == 0) {
            return Intzilla.ZERO;
        }
        if (n == 1) {
            return Intzilla.ONE;
        }

        Intzilla n1 = Intzilla.ZERO;
        Intzilla n2 = Intzilla.ONE;
        Intzilla temp = new Intzilla("21"); // Place holder

        for (int i = 2; i <= n; i++) {
            temp = n1.plus(n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
