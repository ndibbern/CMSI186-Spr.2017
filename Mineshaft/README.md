**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0502
Our last problem-solving paradigm, _backtracking_, exposes you to the algorithmic version of “if at first you don’t succeed, try and try again…_without repeating yourself_.”

## Automated Feedback Setup
In order to connect your repository to our automated code review and feedback system, once you are up and running please create a GitHub issue requesting this on your repository and mention Ed Seim in it (`@SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

You might recall that we have gone up a level with some best practices surrounding this work:

* _You are expected to write your own unit tests._ A starter suite is provided, but it does not cover all of the notable cases. Follow the pattern from the previous assignments. The automated system will now run _your_ tests and tell you how you fare. When grading, we do have our own suite of tests to ensure proper coverage.

* _You are expected to indent and format your code more strictly._ Deductions will accompany severe issues with code formatting/presentation. Please consult the [“Curly-Brace” Languages](http://lmucs.github.io/hacking-guidelines/curly/) section of the [LMU CS Hacking Guidelines](http://lmucs.github.io/hacking-guidelines/) site for details (a Java-specific page has not yet been constructed). The feedback system itself will also provide guidelines and notes on how to format your code.

Points will be deducted if issues reported by the automated feedback system here linger in the final submission.

## Backtracking: Mineshaft
Complete the maze-solving program that is provided in this repository. The overall program is invoked via `Mineshaft` class and takes, as command-line arguments, Steve’s initial location _(sx, sy)_ and the location of his favorite pig _(px, py)_:

    java Mineshaft sx sy px py

The description of the maze to use, formatted as described in class, is read from standard input (i.e., you type it in once the program starts). Thus, the maze can also be prepared in a text file, and that text file redirected into the maze solver via the `<` symbol on the command line. For example:

    java Mineshaft 4 8 9 2 < maze.txt
    
As is, the provided code does not do any maze solving. Your task is to implement the `areWeThereYet` method in the `MazeWalker` class. Data structures and initialization consistent with what was described in class have been provided, but nothing else. You are free to define and implement additional methods to help `areWeThereYet` get its job done. You do not need to modify any other class in the baseline code.

A `MazeWalker` is initialized with a `Maze` object and the desired destination coordinates. The overall program is then structured so that it repeatedly invokes `areWeThereYet` on a `MazeWalker` instance.

`areWeThereYet` should return one of six possible values, enumerated by `WalkerState`: One value indicates that the destination has been reached (`THERE_ALREADY`), another indicates that the destination is unreachable (`IMPOSSIBLE_TO_GET_THERE`), and the rest indicate the next move (`MOVE_LEFT`, `MOVE_UP`, `MOVE_RIGHT`, `MOVE_DOWN`).

### Implementation Notes
The task of modifying or enhancing (or completing!) someone else’s code is something that you will likely encounter frequently in collaborative programming situations. Thus, keep in mind:
- Understanding how your code interacts with the rest of the program may be more difficult than it sounds—talk to me if needed.
- When trying to read and understand my code, think of the characteristics that make it easy or hard to comprehend—and keep those in mind when you write your own code. The need to understand someone else’s code is why we care about style and code presentation!
- Some ready-made maze descriptions are included in the _mazes_ folder. Of course, you may create your own—the format is documented in the `Maze` class.

### Optional Enhancements
If you finish the basic maze solver early, consider the following improvements to the program:
- Make the solver speed customizable through an optional argument; this is currently hardcoded in the `MouseAndCheeseMazeView` class.
- Experiment with different approaches to determining the next step in the maze walk. Options include a “smart” walker that picks a direction based on the pig’s location or a random walker that picks different directions at each step. Make the approach customizable through a command-line argument.
