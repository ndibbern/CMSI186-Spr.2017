public class BagOfCoinsTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests () {
        attempts = 0;
        successes = 0;

        testDefaultConstructorYieldsDefaultFairCoinCount();
        testCustomCoinCountConstructorYieldsCustomFairCoinCount();
        testCustomBiasConstructorYieldsDefaultBiasedCoinCount();
        testFullCustomConstructorYieldsCustomBiasedCoinCount();
        testThrowBagFlipsAllCoinsOnce();
        testResetBagResetsAllCoins();
        testFlipTotalsReturns2ElementArray();
        testFlipHistogramReturnsPartitionElementArrayWithTheRightCoinCount();
        testFlipHistogramRejectsUnevenPartitionCount();

        System.out.println(successes + "/" + attempts + " tests passed.");
        return successes == attempts;
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    private static void testDefaultConstructorYieldsDefaultFairCoinCount() {
        System.out.println("Default constructor should yield the default number of fair coins...");

        try {
            // Overkill to print something per coin, so we'll gather up the results.
            // Though it's true that if you get a failure, you'll need to track things
            // down more closely.
            BagOfCoins bagOfCoins = new BagOfCoins();
            displaySuccessIfTrue(BagOfCoins.DEFAULT_COIN_COUNT == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < bagOfCoins.getCoinCount(); i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && Coin.FAIR_BIAS == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testCustomCoinCountConstructorYieldsCustomFairCoinCount() {
        System.out.println("Custom coin count constructor should yield the custom number of fair coins...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(0);
            displaySuccessIfTrue(0 == bagOfCoins.getCoinCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(1);
            displaySuccessIfTrue(1 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 1; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && Coin.FAIR_BIAS == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(10);
            displaySuccessIfTrue(10 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 10; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && Coin.FAIR_BIAS == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(999);
            displaySuccessIfTrue(999 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 999; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && Coin.FAIR_BIAS == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(7890);
            displaySuccessIfTrue(7890 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 7890; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && Coin.FAIR_BIAS == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testCustomBiasConstructorYieldsDefaultBiasedCoinCount() {
        System.out.println("Custom bias constructor should yield the default number of biased coins...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(0.375);
            displaySuccessIfTrue(BagOfCoins.DEFAULT_COIN_COUNT == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < bagOfCoins.getCoinCount(); i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && 0.375 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(0.875);
            displaySuccessIfTrue(BagOfCoins.DEFAULT_COIN_COUNT == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < bagOfCoins.getCoinCount(); i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && 0.875 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testFullCustomConstructorYieldsCustomBiasedCoinCount() {
        System.out.println("Full custom coin constructor should yield the custom number of biased coins...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(0, 0.625);
            displaySuccessIfTrue(0 == bagOfCoins.getCoinCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(1, 0.1375);
            displaySuccessIfTrue(1 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 1; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && 0.1375 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(10, -2.0);
            displaySuccessIfTrue(10 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 10; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && -2.0 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(999, 5.0);
            displaySuccessIfTrue(999 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 999; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && 5.0 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(7890, 0.925);
            displaySuccessIfTrue(7890 == bagOfCoins.getCoinCount());

            boolean success = true;
            for (int i = 0; success && i < 7890; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && 0.925 == coin.getBias() &&
                        0 == coin.getFlipCount() &&
                        0 == coin.getHeadCount();
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testThrowBagFlipsAllCoinsOnce() {
        System.out.println("Throwing the bag once should flip all coins once...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(7890, 0.925);
            bagOfCoins.throwCoins();

            boolean success = true;
            for (int i = 0; success && i < 7890; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && coin.getFlipCount() == 1;
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testResetBagResetsAllCoins() {
        System.out.println("Resetting the bag should reset all of the coins...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(10, -2.0);
            for (int i = 0; i < 23; i++) { // Arbitrary number of throws.
                bagOfCoins.throwCoins();
            }

            boolean success = true;
            for (int i = 0; success && i < 10; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && coin.getFlipCount() == 23;
            }

            displaySuccessIfTrue(success);

            bagOfCoins.resetCoins();

            success = true;
            for (int i = 0; success && i < 10; i++) {
                Coin coin = bagOfCoins.getCoin(i);
                success = success && coin.getFlipCount() == 0;
            }

            displaySuccessIfTrue(success);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testFlipTotalsReturns2ElementArray() {
        System.out.println("The flip totals should return a 2-element array...");
        System.out.println("(due to randomization we only check the total count, not the specific count values)");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(0.75);
            for (int i = 0; i < 100; i++) { // 100 bag throws.
                bagOfCoins.throwCoins();
            }

            long[] flipTotals = bagOfCoins.getFlipTotals();
            displaySuccessIfTrue(100 * BagOfCoins.DEFAULT_COIN_COUNT == flipTotals[0] + flipTotals[1]);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testFlipHistogramReturnsPartitionElementArrayWithTheRightCoinCount() {
        System.out.println("The flip histogram should return the correctly-sized array and coin count...");
        System.out.println("(due to randomization we only check the totals, not the specific count values)");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(3792, 0.75);
            for (int i = 0; i < 10000; i++) { // 10000 bag throws.
                bagOfCoins.throwCoins();
            }

            int[] flipHistogram = bagOfCoins.getFlipHistogram(10);
            displaySuccessIfTrue(10 == flipHistogram.length);

            int coinCount = 0;
            for (int i = 0; i < 10; i++) {
                coinCount += flipHistogram[i];
            }
            displaySuccessIfTrue(3792 == coinCount);
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(98, 0.425);
            for (int i = 0; i < 512; i++) { // 512 bag throws.
                bagOfCoins.throwCoins();
            }

            int[] flipHistogram = bagOfCoins.getFlipHistogram(16);
            displaySuccessIfTrue(16 == flipHistogram.length);

            int coinCount = 0;
            for (int i = 0; i < 16; i++) {
                coinCount += flipHistogram[i];
            }
            displaySuccessIfTrue(98 == coinCount);
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testFlipHistogramRejectsUnevenPartitionCount() {
        System.out.println("The flip histogram should reject an uneven partition count...");

        try {
            BagOfCoins bagOfCoins = new BagOfCoins(728);
            for (int i = 0; i < 512; i++) { // 512 bag throws.
                bagOfCoins.throwCoins();
            }

            bagOfCoins.getFlipHistogram(10);
            displayFailure(); // If we get here, there was no exception!
        } catch (IllegalArgumentException iaexc) {
            displaySuccessIfTrue(BagOfCoins.UNEVEN_PARTITION_MESSAGE.equals(iaexc.getMessage()));
        } catch (Exception exc) {
            // We want a _specific_ kind of exception.
            displayFailure();
        }
    }
}
