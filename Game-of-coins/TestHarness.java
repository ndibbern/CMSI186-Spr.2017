import java.util.ArrayList;
import java.lang.Class;
import java.lang.reflect.Method;

// WHY DO I HAVE TO IMPORT EXCEPTIONS!!
import java.lang.reflect.InvocationTargetException;

public class TestHarness {
    public static void main (String[] args) {
        ArrayList<String> harnesses = new ArrayList<String>();

        // Add the Classes that are the Test Harnesses
        harnesses.add("CoinTestHarness");
        harnesses.add("BagOfCoinsTestHarness");

        findAndRunHarnesses(harnesses);
    }

    public static void findAndRunHarnesses (ArrayList<String> harnessList) {
        // Get Class objects of harnesses
        ArrayList<Class> harnessClasses = new ArrayList<Class>();
        try {
            for (String harnessName: harnessList) {
                harnessClasses.add(Class.forName(harnessName));
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }

        // Get the method to call for each harness and call it
        try {
            boolean success = true;
            for (Class<?> harness: harnessClasses) {
                Method runTests = harness.getMethod("runTests");
                if (!((boolean) runTests.invoke(null))) {
                    success = false;
                }
            }
            if (success) {
                System.exit(0);
            } else {
                System.exit(1);
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e);
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println(e);
            System.exit(1);
        } catch (InvocationTargetException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
