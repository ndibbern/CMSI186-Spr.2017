public class CarTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests() {
        attempts = 0;
        successes = 0;

        testCarConstructorYieldsCorrectInitialState();
        testCarAdvancesThroughInstructionsCorrectly();
        testCarRendersItselfAsStringCorrectly();
        testCarTurnsCorrectly();
        testCarAdvancesCorrectly();

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

    private static void testCarConstructorYieldsCorrectInitialState() {
        System.out.println("Car constructor should yield a car in the correct initial state...");

        try {
            Car car = new Car(99, 5, 3, Car.Direction.N, "L");
            displaySuccessIfTrue(99 == car.getId());
            displaySuccessIfTrue(5 == car.getStreet());
            displaySuccessIfTrue(3 == car.getAvenue());
            displaySuccessIfTrue(Car.Direction.N == car.getDirection());
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(42, 6, 2, Car.Direction.E, "RL");
            displaySuccessIfTrue(42 == car.getId());
            displaySuccessIfTrue(6 == car.getStreet());
            displaySuccessIfTrue(2 == car.getAvenue());
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(95, 1, 5, Car.Direction.E, "N");
            displaySuccessIfTrue(95 == car.getId());
            displaySuccessIfTrue(1 == car.getStreet());
            displaySuccessIfTrue(5 == car.getAvenue());
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testCarAdvancesThroughInstructionsCorrectly() {
        System.out.println("Car should advance through instructions correctly...");

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "L");
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "R");
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "N");
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "LRRNLN");
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.R == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.N == car.getNextInstruction());
            displaySuccessIfTrue(Car.Instruction.L == car.getNextInstruction());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testCarRendersItselfAsStringCorrectly() {
        System.out.println("Car should convert to the right string...");

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "L");
            displaySuccessIfTrue("car 95: 1 1 E".equals(car.toString()));
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(42, 6, 2, Car.Direction.S, "RL");
            displaySuccessIfTrue("car 42: 6 2 S".equals(car.toString()));
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(88, 25, 98, Car.Direction.W, "LRRNLN");
            displaySuccessIfTrue("car 88: 25 98 W".equals(car.toString()));
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testCarTurnsCorrectly() {
        System.out.println("Car should turn correctly...");
        // Note that this turns a car _in isolation_ of advancing, exactly as a _unit_ test should do.

        try {
            Car car = new Car(88, 25, 98, Car.Direction.W, "LRN");
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.W == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.W == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(99, 1, 1, Car.Direction.S, "L");
            car.turn();
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.N == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.W == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(95, 1, 1, Car.Direction.E, "R");
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.W == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.N == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(42, 19, 11, Car.Direction.E, "NNRLR");
            car.turn();
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.E == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
            car.turn();
            displaySuccessIfTrue(Car.Direction.S == car.getDirection());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }

    private static void testCarAdvancesCorrectly() {
        System.out.println("Car should advance correctly...");
        // Note that this advances a car _in isolation_ of turning, exactly as a _unit_ test should do.

        try {
            Car car = new Car(88, 25, 3, Car.Direction.W, "LRN");
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(2 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(1 == car.getAvenue());

            // Note that the car itself does not enforce any map rules; this is the simulation’s job.
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(0 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(-1 == car.getAvenue());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(88, 25, 3, Car.Direction.E, "LRN");
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(4 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(5 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(6 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(25 == car.getStreet());
            displaySuccessIfTrue(7 == car.getAvenue());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(42, 2, 32, Car.Direction.N, "LRN");
            car.advance();
            displaySuccessIfTrue(1 == car.getStreet());
            displaySuccessIfTrue(32 == car.getAvenue());

            // Note that the car itself does not enforce any map rules; this is the simulation’s job.
            car.advance();
            displaySuccessIfTrue(0 == car.getStreet());
            displaySuccessIfTrue(32 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(-1 == car.getStreet());
            displaySuccessIfTrue(32 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(-2 == car.getStreet());
            displaySuccessIfTrue(32 == car.getAvenue());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }

        try {
            Car car = new Car(88, 25, 3, Car.Direction.S, "LRN");
            car.advance();
            displaySuccessIfTrue(26 == car.getStreet());
            displaySuccessIfTrue(3 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(27 == car.getStreet());
            displaySuccessIfTrue(3 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(28 == car.getStreet());
            displaySuccessIfTrue(3 == car.getAvenue());
            car.advance();
            displaySuccessIfTrue(29 == car.getStreet());
            displaySuccessIfTrue(3 == car.getAvenue());
        } catch(Exception e) {
            displayFailure();
            e.printStackTrace();
        }
    }
}
