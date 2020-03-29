public class IntzillaTestHarness {

    private static int Attempts = 0;
    private static int Successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests() {
        Attempts = 0;
        Successes = 0;

        testConstructorAndToStringReturnCorrespondingValues();
        testEqualsEquatesIdenticalValuesAndViceVersa();
        testAdditionProducesTheRightSumIncludingSign();
        testSubstraction();
        testMultiplication();
        testDivision();
        testGreaterThan();
        testIsLessThan();
        testSwitchSign();
        testTwice();
        testHalve();
        testSetSign();
        testAbsoluteValue();
        testMod();

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

    private static void testConstructorAndToStringReturnCorrespondingValues() {
        System.out.println("Testing constructors and toString...");

        try {
            displaySuccessIfTrue("+1".equals(new Intzilla("1 ").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("+1".equals(new Intzilla("  +1").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("-1".equals(new Intzilla("-1  ").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("0".equals(new Intzilla("0").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("0".equals(new Intzilla().toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new Intzilla("314159265358979323846264338327950288").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("+314159265358979323846264338327950288"
                    .equals(new Intzilla("+314159265358979323846264338327950288").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new Intzilla("-314159265358979323846264338327950288").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            new Intzilla("a");
            displayFailure();
        } catch (Exception e) {
            displaySuccessIfTrue(true);
        }

        try {
            displaySuccessIfTrue("+9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new Intzilla("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new Intzilla("123456789123456789").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("+123456789123456789"
                    .equals(new Intzilla("000123456789123456789").toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testEqualsEquatesIdenticalValuesAndViceVersa() {
        System.out.println("Testing equals...");

        try {
            displaySuccessIfTrue(new Intzilla("123456789123456789")
                    .equals(new Intzilla("123456789123456789")));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(!(new Intzilla("123456789123456789")
                    .equals(new Intzilla("333"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(!(new Intzilla("123456789123456789")
                    .equals(new Intzilla("-123456789123456789"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("123456789123456789")
                    .equals(new Intzilla("000123456789123456789")));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testAdditionProducesTheRightSumIncludingSign() {
        System.out.println("Testing addition...");

        try {
            displaySuccessIfTrue(new Intzilla("0").equals(new Intzilla("0").plus(new Intzilla("0"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("1").equals(new Intzilla("0").plus(new Intzilla("1"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("1").equals(new Intzilla("1").plus(new Intzilla("0"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("2").equals(new Intzilla("1").plus(new Intzilla("1"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("1000").equals(new Intzilla("1").plus(new Intzilla("999"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("1000").equals(new Intzilla("123").plus(new Intzilla("877"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("-999").equals(new Intzilla("-123").plus(new Intzilla("-876"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("-1000").equals(new Intzilla("-123").plus(new Intzilla("-877"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("-1000").equals(new Intzilla("+3000").plus(new Intzilla("-4000"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("-1000").equals(new Intzilla("-4000").plus(new Intzilla("+3000"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("0").equals(new Intzilla("-1").plus(new Intzilla("+1"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("0").equals(new Intzilla("+1").plus(new Intzilla("-1"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("10").equals(new Intzilla("-1").plus(new Intzilla("+11"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue(new Intzilla("10").equals(new Intzilla("+12").plus(new Intzilla("-2"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla x = new Intzilla("+12354");
            displaySuccessIfTrue(new Intzilla("24708").equals(x.plus(x)));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        // For larger values, we allow java.math.BigInteger to serve as a source of truth.
        try {
            displaySuccessIfTrue(("+" + (new java.math.BigInteger("123456789123456789")))
                    .equals(new Intzilla("123456789123456789").plus(new Intzilla()).toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            displaySuccessIfTrue("0".equals(new Intzilla("123456789123456789")
                    .plus(new Intzilla("-123456789123456789")).toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(("+" + expected).equals(new Intzilla("2934097831972391728347612783641927841983569834695")
                    .plus(new Intzilla("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(("+" + expected).equals(new Intzilla("000123456789123456789")
                    .plus(new Intzilla("000123456789123456789")).toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new Intzilla("888888888888888888")
                    .plus(new Intzilla("-999999999999999999")).toString()));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testSubstraction() {
        System.out.println("Testing substraction...");

        try {
            displaySuccessIfTrue(new Intzilla("0").equals(new Intzilla("0").minus(new Intzilla("0"))));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("+4233108251307480031024"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("+58598744820488384738228"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("-58598744820488384738228"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("-4233108251307480031024"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("-27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("+27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("+27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("-27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.minus(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testMultiplication() {
        System.out.println("Testing multiplication...");

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            String correctAnswer = "+853973422267356706546315814220731878020522852";
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals(correctAnswer));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            String correctAnswer = "-853973422267356706546315814220731878020522852";
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals(correctAnswer));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            String correctAnswer = "-853973422267356706546315814220731878020522852";
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals(correctAnswer));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            String correctAnswer = "+853973422267356706546315814220731878020522852";
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals(correctAnswer));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.times(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testDivision() {
        System.out.println("Testing integer division...");

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("+1155727349816"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("-1155727349816"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("-1155727349816"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("+1155727349816"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testGreaterThan() {
        System.out.println("Testing greater than...");
        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(!intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832795");
            displaySuccessIfTrue(!intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(!intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832795");
            displaySuccessIfTrue(!intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(!intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(!intzilla1.isGreaterThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832796");
            displaySuccessIfTrue(intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832794");
            displaySuccessIfTrue(!intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832796");
            displaySuccessIfTrue(!intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832794");
            displaySuccessIfTrue(intzilla2.isGreaterThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testIsLessThan() {
        System.out.println("Testing less than...");
        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(!intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832795");
            displaySuccessIfTrue(!intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(!intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832795");
            displaySuccessIfTrue(!intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(!intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(!intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla1.isLessThan(intzilla2));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832796");
            displaySuccessIfTrue(!intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("31415926535897932384626433832794");
            displaySuccessIfTrue(intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832796");
            displaySuccessIfTrue(intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626433832795");
            Intzilla intzilla2 = new Intzilla("-31415926535897932384626433832794");
            displaySuccessIfTrue(!intzilla2.isLessThan(intzilla1));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testHalve() {
        System.out.println("Testing halve...");

        try {
            Intzilla intzilla = new Intzilla("3141592653589793238");
            displaySuccessIfTrue(intzilla.halve().toString().equals("+1570796326794896619"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-3141592653589793238");
            displaySuccessIfTrue(intzilla.halve().toString().equals("-1570796326794896619"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla.halve().toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testTwice() {
        System.out.println("Testing twice...");

        try {
            Intzilla intzilla = new Intzilla("3141592653589793238");
            displaySuccessIfTrue(intzilla.twice().toString().equals("+6283185307179586476"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-3141592653589793238");
            displaySuccessIfTrue(intzilla.twice().toString().equals("-6283185307179586476"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("3141592653589793239");
            displaySuccessIfTrue(intzilla.twice().toString().equals("+6283185307179586478"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-3141592653589793239");
            displaySuccessIfTrue(intzilla.twice().toString().equals("-6283185307179586478"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla.twice().toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testSwitchSign() {
        System.out.println("Testing switch sign...");

        try {
            Intzilla intzilla = new Intzilla("31415926535897932384626");
            intzilla.switchSign();
            displaySuccessIfTrue(intzilla.toString().equals("-31415926535897932384626"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-31415926535897932384626");
            intzilla.switchSign();
            displaySuccessIfTrue(intzilla.toString().equals("+31415926535897932384626"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = Intzilla.ZERO;
            intzilla.switchSign();
            displaySuccessIfTrue(intzilla.toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testAbsoluteValue() {
        System.out.println("Testing absolute value...");

        try {
            Intzilla intzilla = new Intzilla("31415926535897932384626433832795");
            String correctAnswer = "+31415926535897932384626433832795";
            displaySuccessIfTrue(intzilla.absoluteValue().toString().equals(correctAnswer));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-31415926535897932384626433832795");
            displaySuccessIfTrue(intzilla.absoluteValue().toString().equals("+31415926535897932384626433832795"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = Intzilla.ZERO;
            displaySuccessIfTrue(intzilla.absoluteValue().toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testSetSign() {
        System.out.println("Testing set sign...");

        try {
            Intzilla intzilla = new Intzilla("31415926535897932384626");
            intzilla.setSign((byte) -1);
            displaySuccessIfTrue(intzilla.toString().equals("-31415926535897932384626"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla = new Intzilla("-31415926535897932384626");
            intzilla.setSign((byte) 1);
            displaySuccessIfTrue(intzilla.toString().equals("+31415926535897932384626"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testMod() {
        System.out.println("Testing mod...");

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284");
            displaySuccessIfTrue(intzilla1.mod(intzilla2).toString().equals("+703548882"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284");
            displaySuccessIfTrue(intzilla1.mod(intzilla2).toString().equals("+703548882"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("27182818284");
            displaySuccessIfTrue(intzilla1.mod(intzilla2).toString().equals("-703548882"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-31415926535897932384626");
            Intzilla intzilla2 = new Intzilla("-27182818284");
            displaySuccessIfTrue(intzilla1.mod(intzilla2).toString().equals("-703548882"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("27182818284590452353602");
            displaySuccessIfTrue(intzilla1.mod(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = Intzilla.ZERO;
            Intzilla intzilla2 = new Intzilla("-27182818284590452353602");
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("0"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ONE;
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("+27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Intzilla intzilla1 = new Intzilla("-27182818284590452353602");
            Intzilla intzilla2 = Intzilla.ONE;
            displaySuccessIfTrue(intzilla1.div(intzilla2).toString().equals("-27182818284590452353602"));
        } catch (Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }
}
