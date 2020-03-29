public class Car {

    public static enum Instruction {
        L(Direction.W, Direction.E, Direction.N, Direction.S),
        N(Direction.N, Direction.S, Direction.E, Direction.W),
        R(Direction.E, Direction.W, Direction.S, Direction.N);

        final Direction directionAfterNorth;
        final Direction directionAfterSouth;
        final Direction directionAfterEast;
        final Direction directionAfterWest;

        Instruction(Direction directionAfterNorth, Direction directionAfterSouth, Direction directionAfterEast, Direction directionAfterWest) {
            this.directionAfterNorth = directionAfterNorth;
            this.directionAfterSouth = directionAfterSouth;
            this.directionAfterEast = directionAfterEast;
            this.directionAfterWest = directionAfterWest;
        }

        Direction nextDirection(Direction direction) {
            if (direction == Direction.N) {
                return directionAfterNorth;
            }else if (direction == Direction.S) {
                return directionAfterSouth;
            }else if (direction == Direction.W) {
                return directionAfterWest;
            }else {
                return directionAfterEast;
            }
        }
    }

    public static enum Direction {
        E(0, 1),
        N(-1, 0),
        W(0, -1),
        S(1, 0);

        private int streetDifference;
        private int avenueDifference;

        Direction(int  streetDifference, int avenueDifference) {
            this.streetDifference = streetDifference;
            this.avenueDifference = avenueDifference;
        }

        public int nextAvenue(int avenue) {
            return avenue + this.avenueDifference;
        }

        public int nextStreet(int street) {
            return street + this.streetDifference;
        }
    }

    private String instructionList;
    private int id, street, avenue;
    private Instruction instruction;
    private Direction direction;
    private int counter;


    public Car(int id, int street, int avenue, Direction direction, String instructionList) {
        this.id = id;
        this.street = street;
        this.avenue = avenue;
        this.direction = direction;
        this.instructionList = instructionList;
        this.counter = 0;
   }


   public void advance() {
       this.avenue = direction.nextAvenue(avenue);
       this.street = direction.nextStreet(street);
       return;
   }

   public int getAvenue() {
       return this.avenue;
   }

   public int getId() {
       return this.id;
   }

   public Direction getDirection() {
       return this.direction;
   }

   public Instruction getNextInstruction() {
        int instructionIndex = counter % instructionList.length();
        instruction = Instruction.valueOf(String.valueOf(instructionList.charAt(instructionIndex)));
        counter++;
       return instruction;
   }

   public int getStreet() {
       return this.street;
   }

   public String toString() {
       return "car " + this.id + ":" + " "+ this.street + " " + this.avenue + " " + this.direction;
   }

   public void turn() {
       direction = getNextInstruction().nextDirection(direction);
       return;
   }

}
