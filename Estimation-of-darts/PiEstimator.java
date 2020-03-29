public class PiEstimator {

    public static void main(String[] args) {

        if (args.length == 1) {
            try {
                int nThrows = Integer.parseInt(args[0]);
                int nSuccess = 0;
                double x = 0;
                double y = 0; // Just so Jenkins will not complain...

                if (nThrows > 0) {
                    //  Start

                    for (int i = 0; i < nThrows; i++) {
                        x = Math.random();
                        y = Math.random();

                        if (x * x + y * y <= 1) {
                            nSuccess++;
                            //  In
                        } else {
                            //  Out
                        }
                    }
                    // End
                    System.out.println(4 * (double)nSuccess / (double)nThrows);
                } else {
                    System.out.println("Please input a positive integer.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please input a positive integer.");
            }
        } else {
            System.out.println("Please input only one positive integer.");
        }
    }
}
