public class CoinTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests () {
        attempts = 0;
        successes = 0;

        testDefaultConstructorYieldsFairCoin();
        testCustomConstructorStoresBiasCorrectly();
        test1000FairCoinFlipsRecordsResultsCorrectly();
        test1000HeadBiasedCoinFlipsRecordsResultsCorrectly();
        test1000TailBiasedCoinFlipsRecordsResultsCorrectly();
        testResultClearsFlipRecordCorrectly();

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

    private static void testDefaultConstructorYieldsFairCoin() {
        System.out.println("Default constructor should yield a fair coin...");

        try {
            Coin coin = new Coin();
            displaySuccessIfTrue(Coin.FAIR_BIAS == coin.getBias());
            displaySuccessIfTrue(0 == coin.getFlipCount());
            displaySuccessIfTrue(0 == coin.getHeadCount());
            displaySuccessIfTrue(0 == coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testCustomConstructorStoresBiasCorrectly() {
        System.out.println("Custom constructor should yield an unfair coin...");

        try {
            Coin coin = new Coin(-1.0);
            displaySuccessIfTrue(-1.0 == coin.getBias());
            displaySuccessIfTrue(0 == coin.getFlipCount());
            displaySuccessIfTrue(0 == coin.getHeadCount());
            displaySuccessIfTrue(0 == coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            Coin coin = new Coin(0.25);
            displaySuccessIfTrue(0.25 == coin.getBias());
            displaySuccessIfTrue(0 == coin.getFlipCount());
            displaySuccessIfTrue(0 == coin.getHeadCount());
            displaySuccessIfTrue(0 == coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            Coin coin = new Coin(0.75);
            displaySuccessIfTrue(0.75 == coin.getBias());
            displaySuccessIfTrue(0 == coin.getFlipCount());
            displaySuccessIfTrue(0 == coin.getHeadCount());
            displaySuccessIfTrue(0 == coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            Coin coin = new Coin(2.0);
            displaySuccessIfTrue(2.0 == coin.getBias());
            displaySuccessIfTrue(0 == coin.getFlipCount());
            displaySuccessIfTrue(0 == coin.getHeadCount());
            displaySuccessIfTrue(0 == coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void test1000FairCoinFlipsRecordsResultsCorrectly() {
        System.out.println("1000 fair coin flips should record results correctly...");
        System.out.println("(due to randomization, we cannot enforce the frequency; just total flips)");

        try {
            Coin coin = new Coin();
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void test1000HeadBiasedCoinFlipsRecordsResultsCorrectly() {
        System.out.println("1000 head-biased coin flips should record results correctly...");
        System.out.println("(due to randomization, we cannot enforce the frequency; just total flips)");

        try {
            Coin coin = new Coin(0.25);
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            Coin coin = new Coin(-1.0);
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void test1000TailBiasedCoinFlipsRecordsResultsCorrectly() {
        System.out.println("1000 tail-biased coin flips should record results correctly...");
        System.out.println("(due to randomization, we cannot enforce the frequency; just total flips)");

        try {
            Coin coin = new Coin(0.75);
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }

        try {
            Coin coin = new Coin(2.0);
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }

    private static void testResultClearsFlipRecordCorrectly() {
        System.out.println("Counts should reset correctly...");
        System.out.println("(due to randomization, we cannot enforce the frequency; just total flips)");

        try {
            Coin coin = new Coin(0.75);
            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());

            coin.reset(); // <--- What we're testing.

            for (int i = 0; i < 1000; i++) {
                coin.flip();
            }

            System.out.println("Got " + coin.getHeadCount() + " heads, " + coin.getTailCount() + " tails.");
            displaySuccessIfTrue(1000 == coin.getFlipCount());
            displaySuccessIfTrue(1000 == coin.getHeadCount() + coin.getTailCount());
        } catch (Exception exc) {
            displayFailure();
        }
    }
}
