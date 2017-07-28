import java.util.Arrays;

public class AlexanderHamilton {

    public static String DEFAULT_INDICATOR = new String("-");
    public static int DEFAULT_THROWS = 1000;
    public static int DEFAULT_PARTITIONS = 100;

    public static void throwCoinsNTimes (BagOfCoins aBag, int nThrows) {
        for (int i = 0; i < nThrows ; i++) {
            aBag.throwCoins();
        }
        return;
    }

    public static void printHistogram(int[] histogram, int partitionSize) {
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > 0) {
                if (i == histogram.length - 1){
                    System.out.print((i * partitionSize) + "-" +
                                     (i * partitionSize + partitionSize) + " ");
                } else {
                    System.out.print((i * partitionSize) + "-" +
                                    (i * partitionSize + partitionSize - 1) + " ");
                }

                for (int j = 1; j <= histogram[i]; j += 14) {
                    // after performing tests, a step of 14 seemed appropriate
                    System.out.print("*");
                }
                System.out.print(" " + histogram[i] + " coins");
                System.out.println();
            }
        }
        return;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            int nThrows = 1000;
            int nPartitions = 100;

            BagOfCoins aBag = new BagOfCoins();
            aBag.resetCoins();
            throwCoinsNTimes(aBag, nThrows);
            int [] histogram = aBag.getFlipHistogram(nPartitions);
            printHistogram(histogram, nThrows/nPartitions);

        } else if (args.length == 4) {
            try {
                int nCoins , nThrows , nPartitions;
                double coinBias;

                if (DEFAULT_INDICATOR.equals(args[0])) {
                    nCoins = BagOfCoins.DEFAULT_COIN_COUNT;
                } else {
                    nCoins = Integer.parseInt(args[0]);
                }

                if (DEFAULT_INDICATOR.equals(args[1])) {
                    nThrows = DEFAULT_THROWS;
                } else {
                    nThrows = Integer.parseInt(args[1]);
                }

                if (DEFAULT_INDICATOR.equals(args[2])) {
                    nPartitions = DEFAULT_PARTITIONS;
                } else {
                    nPartitions = Integer.parseInt(args[2]);
                }
                if (DEFAULT_INDICATOR.equals(args[3])) {
                    coinBias = Coin.FAIR_BIAS;
                } else {
                    coinBias = Double.parseDouble(args[3]);
                }

               if ( nCoins > 0 && nThrows > 0
                    && nPartitions > 0 && coinBias >= 0 && coinBias <= 1 ) {
                        //FIX FOR WHEN BIAS IS 0
                   BagOfCoins aBag = new BagOfCoins(nCoins, coinBias);
                   aBag.resetCoins();
                   throwCoinsNTimes(aBag, nThrows);
                   int [] histogram = aBag.getFlipHistogram(nPartitions);
                   printHistogram(histogram, nThrows/nPartitions);
               } else {
                   System.out.println("Negative amounts are not permitted, and the bias should be between 0-1.");
               }
           } catch (NumberFormatException ignore) {
               System.out.println("Supplied values must be integers for first 3 and double for last.");
           } catch (IllegalArgumentException iae){
               System.out.println(iae.getMessage());
               }
        } else {
            System.out.println("One or more of the supplied values is not valid");
        }
    }
}
