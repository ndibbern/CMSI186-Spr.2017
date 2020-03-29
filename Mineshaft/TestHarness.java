import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestHarness {

    public static void main(String[] args) {
        List<String> harnesses = new ArrayList<String>();

        // Add the Classes that are the Test Harnesses
        harnesses.add("MazeWalkerTestHarness");

        findAndRunHarnesses(harnesses);
    }

    public static void findAndRunHarnesses(List<String> harnessList) {
        // Get Class objects of harnesses
        List<Class<?>> harnessClasses = new ArrayList<Class<?>>();
        try {
            for (String harnessName : harnessList) {
                harnessClasses.add(Class.forName(harnessName));
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }

        // Get the method to call for each harness and call it
        try {
            boolean success = true;
            for (Class<?> harness : harnessClasses) {
                Method runTests = harness.getMethod("runTests");
                if (!((boolean)runTests.invoke(null))) {
                    success = false;
                }
            }

            System.exit(success ? 0 : 1);
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
