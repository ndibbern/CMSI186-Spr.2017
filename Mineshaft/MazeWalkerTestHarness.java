public class MazeWalkerTestHarness {

    private static int Attempts = 0;
    private static int Successes = 0;

    public static void main(String[] args) {
        runTests();
    }

    public static boolean runTests() {
        Attempts = 0;
        Successes = 0;

        testNormalCheeseFinding();
        testFutileCheeseFinding();

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

    /**
     * Tests normal cheese-finding.
     */
    public static void testNormalCheeseFinding() {
        Maze maze = new Maze("-- ##");
        MazeWalker mazeWalker = new MazeWalker(maze, 1, 0);
        // For this maze, the mouse must find the cheese in one move, regardless
        // of the algorithm.
        displaySuccessIfTrue(MazeWalker.WalkerState.THERE_ALREADY == mazeWalker.areWeThereYet(1, 0));

        mazeWalker = new MazeWalker(maze, 1, 0);
        // This time, we expect two moves, also regardless of the algorithm.
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_RIGHT == mazeWalker.areWeThereYet(0, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.THERE_ALREADY == mazeWalker.areWeThereYet(1, 0));

        // Check directional choices; again, we use mazes with only one choice
        // to ensure independence from the specific path-finding approach.
        mazeWalker = new MazeWalker(maze, 0, 0);
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_LEFT == mazeWalker.areWeThereYet(1, 0));
        mazeWalker = new MazeWalker(new Maze("- - -"), 0, 1);
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_DOWN == mazeWalker.areWeThereYet(0, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_UP == mazeWalker.areWeThereYet(0, 2));

        // Check the degenerate case: nowhere to go from the start.
        mazeWalker = new MazeWalker(new Maze("-#-"), 2, 0);
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(0, 0));
    }

    /**
     * Tests futile cheese-finding. In particular, we need to make sure that
     * every open square is searched.
     */
    public static void testFutileCheeseFinding() {
        // The maze is designed so that the walker can only follow one path,
        // regardless of the specific path-finding approach.
        Maze maze = new Maze("---#-");
        MazeWalker mazeWalker = new MazeWalker(maze, 4, 0);
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_RIGHT == mazeWalker.areWeThereYet(0, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_RIGHT == mazeWalker.areWeThereYet(1, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_LEFT == mazeWalker.areWeThereYet(2, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_LEFT == mazeWalker.areWeThereYet(1, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.THERE_ALREADY == mazeWalker.areWeThereYet(4, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(0, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(1, 1));
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(6, 0));
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(2, 1));
        displaySuccessIfTrue(MazeWalker.WalkerState.IMPOSSIBLE_TO_GET_THERE == mazeWalker.areWeThereYet(2, 2));

        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_RIGHT ==
                            mazeWalker.oppositeDirection(MazeWalker.WalkerState.MOVE_LEFT));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_LEFT ==
                            mazeWalker.oppositeDirection(MazeWalker.WalkerState.MOVE_RIGHT));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_UP ==
                            mazeWalker.oppositeDirection(MazeWalker.WalkerState.MOVE_DOWN));
        displaySuccessIfTrue(MazeWalker.WalkerState.MOVE_DOWN ==
                            mazeWalker.oppositeDirection(MazeWalker.WalkerState.MOVE_UP));

        boolean[][] beenThere = mazeWalker.getBeenThere();
        displaySuccessIfTrue(beenThere[0][0]);
        displaySuccessIfTrue(beenThere[0][1]);
        displaySuccessIfTrue(beenThere[0][2]);
        displaySuccessIfTrue(!beenThere[0][4]);
        displaySuccessIfTrue(!beenThere[0][3]);
    }
}
