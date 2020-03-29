public class MakeOptimalChangeTestHarness {

    private static int Attempts = 0;
    private static int Successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests() {
        Attempts = 0;
        Successes = 0;

        testUsaDenomiationsAreOptimal();
        cero();
        unitedKingdom();
        tie();
        impossible();
        uruguay();
        euro();
        testClassExample();

        System.out.println(Successes + "/" + Attempts + " tests passed.");
        return Successes == Attempts;
    }

    private static void displaySuccessIfTrue(boolean value) {
        Attempts++;
        Successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void testUsaDenomiationsAreOptimal() {
        int[] usaDenominations = new int[] {25, 10, 5, 1};

        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 99);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    public static void testClassExample() {
        int[] usaDenominations = new int[] {1, 4, 9};

        Tally result = MakeOptimalChange.makeOptimalChange(usaDenominations, 12);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(3 == result.getElement(1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    public static void cero() {
        int[] localDenominations = new int[] {1, 12, 7, 9};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 0);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void unitedKingdom() {
        int[] localDenominations = new int[] {1, 2, 5, 10, 20, 50};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 13223);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(264 == result.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void uruguay() {
        int[] localDenominations = new int[] {5, 2, 1, 50, 10};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 10);
        try {
            displaySuccessIfTrue(0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void euro() {
        int[] localDenominations = new int[] {2, 1, 50, 20, 10};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 72);
        try {
            displaySuccessIfTrue(1 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void tie() {
        int[] localDenominations = new int[] {2, 6, 10};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 12);
        try {
            displaySuccessIfTrue(1 == result.getElement(0) || 0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1) || 0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2) || 0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        localDenominations = new int[] {4, 1, 10};

        result = MakeOptimalChange.makeOptimalChange(localDenominations, 12);
        try {
            displaySuccessIfTrue(3 == result.getElement(0) || 0 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1) || 0 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == result.getElement(2) || 0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

    public static void impossible() {
        int[] localDenominations = new int[] {2109, 71, 65, 100};

        Tally result = MakeOptimalChange.makeOptimalChange(localDenominations, 128);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(localDenominations, 12);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(localDenominations, 64);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(localDenominations, 66);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        result = MakeOptimalChange.makeOptimalChange(localDenominations, 120);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }

}
