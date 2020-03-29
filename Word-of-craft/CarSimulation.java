import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CarSimulation {

    public static void main(String[] args) {
        // Free code! File processing has been implemented for you.
        Car[] cars = processCarInput();
        if (cars == null) { // processCarInput returns null if something went wrong.
            return;
        }

        boolean runProgram = true;
        //Check all cars have different id's
        for (int i = 0; i < cars.length; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[i].getId() == cars[j].getId()) {
                    System.out.println("No two cars may have the same identifier.");
                    runProgram = false;
                }
            }
        }
        //Check all cars are within the correct bounds
        boolean outOfBounds = false;
        for (Car c : cars) {
            if (c.getStreet() > 10 || c.getStreet()  < 0
            || c.getAvenue() > 10 || c.getAvenue() < 0) {
                runProgram = false;
                outOfBounds = true;
            }
        }
        if (outOfBounds) {
            System.out.println("Cars must be restricted to a 10x10 street/avenue map");
        }

        //Run main program
        if (runProgram) {
            boolean flag = true;
            int time = 0;
            int carToLeave = 0, carToCrashOne = 0, carToCrashTwo = 0;
            int exitType = 0;

            do {
                System.out.println("t = " + time);
                time++;

                //Turn car
                for (Car c : cars) {
                    System.out.println(c);
                    c.turn();
                }
                System.out.printf("\n");
                System.out.println("t = " + time);

                //Advance car
                for (Car c : cars) {
                    System.out.println(c);
                    c.advance();
                }
                //Check if a car is leaving the grid
                for (Car c : cars) {
                    if (c.getStreet() == 11 || c.getStreet()  == 0
                        || c.getAvenue() == 11 || c.getAvenue() == 0) {
                        carToLeave = c.getId();
                        flag = false;
                        exitType = 1;
                    }
                }
                System.out.printf("\n");

                //Check if cars crash
                for (int i = 0; i < cars.length; i++) {
                    for (int j = i + 1; j < cars.length; j++) {
                        if (cars[i].getAvenue() == cars[j].getAvenue()
                        && cars[i].getStreet() == cars[j].getStreet()) {
                            flag = false;
                            carToCrashOne = cars[i].getId();
                            carToCrashTwo = cars[j].getId();
                            //Print the crash
                            System.out.println("t = " + time);
                            for (Car c : cars) {
                                System.out.println(c);
                            }
                            System.out.printf("\n");
                        }
                    }
                }
            } while (flag);
            //Print exit message
            if (exitType == 1) {
                System.out.println("Car about to leave: " + carToLeave);
            }else {
                System.out.println("Same intersection: car " + carToCrashOne + " and car " + carToCrashTwo);
            }

        }
    }

    /**
     * Note: advanced Java ahead. Input processing is ahead of your current pay grade so this code is
     * given for free.
     */
    private static Car[] processCarInput() {
        Scanner scanner = new Scanner(new BufferedReader(new
            InputStreamReader(System.in)));
        try {
            scanner.useDelimiter("\\Z");
            if (!scanner.hasNext()) {
                System.err.println("No cars provided.");
                return null;
            }

            String fullCarSpecification = scanner.next();
            String[] carSpecificationStrings = fullCarSpecification.split("\n");

            Car[] result = new Car[carSpecificationStrings.length];
            for (int i = 0; i < carSpecificationStrings.length; i++) {
                String carSpecificationString = carSpecificationStrings[i];
                String[] carSpecifications = carSpecificationString.split(" ");
                if (carSpecifications.length != 5) {
                    System.err.println("A car specification must have an id, a starting street, " +
                            "a starting avenue, an initial direction (NSEW) and instructions (R/L/N).");
                    return null;
                }

                try {
                    int id = Integer.parseInt(carSpecifications[0]);
                    int street = Integer.parseInt(carSpecifications[1]);
                    int avenue = Integer.parseInt(carSpecifications[2]);
                    Car.Direction direction = Car.Direction.valueOf(carSpecifications[3]);
                    String instructions = carSpecifications[4];
                    result[i] = new Car(id, street, avenue, direction, instructions);
                } catch (NumberFormatException nfe) {
                    System.err.println("The car specification '" + carSpecificationString +
                            "' is not formatted correctly.");
                    return null;
                } catch (IllegalArgumentException iae) {
                    System.err.println("Directions must be one of N/S/E/W and instructions must be a sequence of " +
                            "R/L/Ns.");
                    return null;
                }
            }

            scanner.close();
            return result;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
