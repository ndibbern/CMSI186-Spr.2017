import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class DateCounterTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_isLeapYear();
        test_daysInMonth();
        test_isValidDate();
        test_daysBetween();
        test_ageInDays();

        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displayFailure();
    }

    private static void test_isLeapYear() {
        System.out.println("Testing isLeapYear...");

        try {
            displaySuccessIfTrue(DateCounter.isLeapYear(1600));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1700));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1800));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1900));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(DateCounter.isLeapYear(1992));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1993));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1994));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isLeapYear(1995));
        } catch (Exception e) {
            displayFailure();
        }
    }

    private static void test_daysInMonth() {
        System.out.println("Testing daysInMonth...");

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(2001, 1));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(28 == DateCounter.daysInMonth(2003, 2));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(29 == DateCounter.daysInMonth(2004, 2));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(2014, 3));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(30 == DateCounter.daysInMonth(2012, 4));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(1993, 5));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(30 == DateCounter.daysInMonth(1994, 6));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(1995, 7));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(1865, 8));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(30 == DateCounter.daysInMonth(2102, 9));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(1993, 10));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(30 == DateCounter.daysInMonth(1999, 11));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(31 == DateCounter.daysInMonth(2014, 12));
        } catch (Exception e) {
            displayFailure();
        }
    }

    private static void test_isValidDate() {
        System.out.println("Testing isValidDate...");

        try {
            displaySuccessIfTrue(DateCounter.isValidDate(2000, 1, 1));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isValidDate(2001, 2, 29));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(DateCounter.isValidDate(2014, 12, 31));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isValidDate(2000, 12, 0));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isValidDate(2005, 12, 32));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isValidDate(2005, 0, 15));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(!DateCounter.isValidDate(2005, 13, 1));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(DateCounter.isValidDate(2004, 2, 29));
        } catch (Exception e) {
            displayFailure();
        }
    }

    private static void test_daysBetween() {
        System.out.println("Testing daysBetween...");

        try {
            displaySuccessIfTrue(0 == DateCounter.daysBetween(2005, 3, 15, 2005, 3, 15));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == DateCounter.daysBetween(2005, 3, 15, 2005, 3, 16));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == DateCounter.daysBetween(2005, 3, 16, 2005, 3, 15));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1 == DateCounter.daysBetween(2005, 3, 31, 2005, 4, 1));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(3 == DateCounter.daysBetween(2005, 12, 30, 2006, 1, 2));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(365 == DateCounter.daysBetween(2005, 8, 15, 2006, 8, 15));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(366 == DateCounter.daysBetween(2007, 8, 15, 2008, 8, 15));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(364 == DateCounter.daysBetween(2001, 8, 15, 2002, 8, 14));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(508 == DateCounter.daysBetween(2006, 3, 15, 2007, 8, 5));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1239 == DateCounter.daysBetween(2005, 3, 15, 2008, 8, 5));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(1060 == DateCounter.daysBetween(2005, 11, 15, 2008, 10, 10));
        } catch (Exception e) {
            displayFailure();
        }

        try {
            displaySuccessIfTrue(8638 == DateCounter.daysBetween(2001, 11, 15, 2025, 7, 10));
        } catch (Exception e) {
            displayFailure();
        }

    }

    private static void test_ageInDays() {
        System.out.println("Testing ageInDays...");

        // For these tests, we use LocalDate behavior as our gold standard.
        LocalDateTime today = LocalDateTime.now();
        try {
            LocalDateTime birthday = LocalDateTime.of(1992, Month.MAY, 3, 0, 0);
            displaySuccessIfTrue(DateCounter.ageInDays(1992, 5, 3) ==
                    Duration.between(birthday, today).toDays());
        } catch (Exception e) {
            displayFailure();
        }

        try {
            LocalDateTime birthday = LocalDateTime.of(2016, Month.JANUARY, 24, 0, 0);
            displaySuccessIfTrue(DateCounter.ageInDays(2016, 1, 24) ==
                    Duration.between(birthday, today).toDays());
        } catch (Exception e) {
            displayFailure();
        }
    }
}
