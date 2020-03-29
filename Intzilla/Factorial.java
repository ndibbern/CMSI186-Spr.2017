public class Factorial {

    public static void main(String[] args) {
        /*
        outputs the factorial of n (or n!), that is, the product of all positive integers less than or equal to n.
        For example, 7! is 7 × 6 × 5 × 4 × 3 × 2 × 1 = 5040.
        The program's argument will be a single Java int;
        so, to determine the factorial of 21, we would run the program like this:
        java Factorial 21
        */
        if (args.length == 1) {
            try {
                long l = Long.parseLong(args[0]);
                Intzilla i = factorial(l);
                System.out.println(l + " factorial is " + i);
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a positive integer");
            } catch (IllegalArgumentException eae) {
                System.out.println(eae.getMessage());
            }
        } else {
            System.out.println("Please input only one positive integer");
        }
    }

    public static Intzilla factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorials of negative numbers can not be computed");
        }
        if (n <= 1) {
            return Intzilla.ONE;
        }
        Intzilla answer = Intzilla.valueOf(n).times(factorial(n - 1));
        return answer;
    }
}
