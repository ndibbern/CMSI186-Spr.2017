/**
 * This class provides an executable wrapper for an optimal change-making algorithm,
 * implemented via dynamic programming.
 */
public class MakeOptimalChange {

    /**
     * The executable entry point. Arguments include a comma-separated list of denominations
     * (without spaces) and the amount for which to make change.
     *
     * @param args
     *            a comma-separated list of denominations (without spaces) and the amount for which to make change
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {
            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.");
                System.out.println();
                printUsage();
                return;
            }

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.");
                    System.out.println();
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.");
                        System.out.println();
                        printUsage();
                        return;
                    }
                }
            }

            Tally change = makeOptimalChange(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- " + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.");
            System.out.println();
            printUsage();
        }
    }

    /**
     * Returns the coin tally that represents the optimal change (fewest coins) for the given
     * amount using the given denominations.
     *
     * @param denominations
     *            Integer array of denomination values
     * @param amount
     *            The amount for which to make change
     * @return the coin tally that represents optimal change (fewest coins)
     */
    public static Tally makeOptimalChange(int[] denominations, int amount) {
        Tally[][] coinGrid = new Tally[denominations.length][amount + 1];

        for (int i = 0; i < coinGrid.length; i++) {
            for (int j = 0; j < coinGrid[0].length; j++) {

                int[] data = new int[denominations.length];

                if (j == 0) {
                    coinGrid[i][j] = new Tally(denominations.length);
                    continue;
                }
                if (denominations[i] <= j) {
                    coinGrid[i][j] = new Tally(denominations.length);
                    coinGrid[i][j].setElement(i, 1);

                    //Add solution to remainder
                    int remaining = j - denominations[i];
                    if (coinGrid[i][remaining].isImpossible()) {
                        coinGrid[i][j] = Tally.IMPOSSIBLE;
                    } else {
                        coinGrid[i][j] = coinGrid[i][j].add(coinGrid[i][remaining]);
                    }
                } else {
                    coinGrid[i][j] = Tally.IMPOSSIBLE;
                }

                //Check to see of the top solution is better
                if (i > 0) {
                    if (!coinGrid[i - 1][j].isImpossible() &&
                        coinGrid[i][j].total() > coinGrid[i - 1][j].total()
                        || coinGrid[i][j].isImpossible()) {
                        coinGrid[i][j] = coinGrid[i - 1][j];
                    }
                }
            }
        }
        return coinGrid[denominations.length - 1][amount];
    }

    private static void printUsage() {
        System.out.println("Usage: java MakeOptimalChange <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }

}
