**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0313
With this assignment, we are in “full 186” mode: from here on, assignments are distinct examples of a selected paradigm for problem-solving. This particular one introduces you to _discrete event simulation_.

## Background Reading
If you want to learn more about discrete event simulations, you can start with the Wikipedia article:

https://en.wikipedia.org/wiki/Discrete_event_simulation

In terms of programming, you will want to take a closer look at _enums_ for this go-round. An enum is a special kind of class, intended to express a known, finite domain of values:

https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

You’ve already seen these; with this assignment you will be using them more deeply.

## Automated Feedback Setup
In order to connect your repository to our automated code review and feedback system, once you are up and running please send your repository’s URL to Ed Seim. You can either find him in person in the lab, tweet him at [https://twitter.com/SirSeim](https://twitter.com/SirSeim), or create a GitHub issue on your repository and mention him in it (`@SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

To assist you in development and as a source of further feedback, test programs are provided with this repository. The test programs test the supporting methods for each program but not the full command line invocations. You will be shown how to use these programs in class. The test programs will also be run automatically whenever you update your work on GitHub. _Make sure that the test program passes._ I have my own additional test program for making sure that all cases are covered.

_Points will be deducted if issues reported by the automated feedback system here linger in the final submission._

## Discrete Event Simulation: World of Carcraft
> Traffic simulations are a Dr. Dorin favorite, and in fact much of this descriptive text is written by him. Programs like these are also particularly topical these days, with self-driving cars appearing to be imminent. This gives you a highly introductory taste of the kind of logic that you might need in order to implement such vehicles.

In a certain town there are twenty roads: ten are _streets_ that run east-west, and ten are _avenues_ that run north-south. The streets are numbered, beginning with First Street at the north end of town; similarly, First Avenue is at the west end of town. Intersections on the town's perimeter (e.g., all along First Avenue) are called _exterior_ intersections; all others are _interior_ intersections. All roads permit two-way traffic; adjacent streets, like adjacent avenues, are 250 feet apart; and all intersections form right angles.

At time _t = 0_, some cars begin driving from various intersections. (For this assignment you should assume—totally unrealistically—that cars always travel at some common, constant rate of speed.) Each driver (or self-driving vehicle!) will have been given individual driving instructions. During each unit of time, each driver **first** carries out the next instruction, **then** advances exactly one block, to the next intersection.

You are to implement a `Car` class that defines the state and behavior of a single car. Then, implement a `CarSimulation` class that runs the town simulation described above. The design of `Car` [is specified](http://myweb.lmu.edu/dondi/spring2017/cmsi186/car); you must follow it. The `CarSimulation` program has been started for you, but the rest of its design is yours to determine, as long as it behaves as specified below.

### Car File
The cars in your simulation will be specified in a plain text file; a sample is provided with the assignment repository. Feel free to make more of these in order to test your simulation or try out some interesting scenarios.

Start the simulation by sending the car file into your program via the `<` command line directive. For example, to start `CarSimulation` using the cars defined in _cars-sample.txt_, you would invoke this command:

    java CarSimulation < cars-sample.txt

For ad hoc testing, you may also define the cars manually. To do this, run `CarSimulation` as you normally would:

    java CarSimulation

You won’t see a prompt, but at this point, you may enter your cars as specified below. To conclude data entry, type `Ctrl-D` on macOS and Linux or `Ctrl-Z` on Windows on a blank line. The simulation then proceeds from that point.

Each line of the text file specifies one car. For each car there will be five (5) space-separated values that specify, respectively:
1. a numeric identifier for the car;
2. its starting street;
3. its starting avenue;
4. the direction in which it is pointing (either `N`, `E`, `S`, or `W`);
5. driving instructions: a string formed from the characters `L`, `R`, and `N`, meaning left turn, right turn, and no turn. (These strings are actually _necklaces_ in the sense that, when the last character of the string has been processed, we return to the beginning of the string.)

For example, the provided sample car file (_cars-sample.txt_) looks like this:

    42 5 3 N L
    95 6 2 E RL
    64 1 5 E N

This indicates that there is a car with ID `42` at Fifth Street and Third Avenue, heading north, with instructions to turn left at every intersection; a second car with ID `95` at Sixth Street and Second Avenue, heading east, with instructions to turn right, then left, then right, then left, etc.; and a third car with ID `64` at First Street and Fifth Avenue, heading east, with instructions to just keep going straight.

### Simulation Behavior
The starter `CarSimulation` code implements the processing of a car file for you, as well as any error checks involved with processing the car input. After receiving the array of `Car` objects, _your_ code should perform these checks:
- Make sure that no car is out of bounds. If any car is found to be beyond First to Tenth Street and First to Tenth Avenue, display the message `Cars must be restricted to a 10x10 street/avenue map.` and exit.
- Make sure that no two cars have the same numeric identifier. If duplicates are found, display the message `No two cars may have the same identifier.` and exit.

Your program should:
- Determine the first time (after _t = 0_) at which two or more cars arrive at the same intersection **or** some car attempts to leave the grid (e.g., a car on First Street tries to travel north).
- As the simulation progresses, produce a periodic status report that indicates the time, location, and direction (heading) of every car in town. In order to use the simulation visualizer described in the next section, make sure that this status report adheres to the format specified there.

Two or more cars may start in the same intersection; and observe that, from some starting configurations, neither of the specified termination events will ever occur, and your simulation will run indefinitely. (Hit `Ctrl-C` to stop it.)

### Simulation Visualizer
To assist in understanding and debugging your simulation, a rudimentary _simulation visualizer_ is included in your repository. The simulation visualizer is a completely separate program that reads the output of your simulation program and displays these data graphically. The program is called `Town2D`. In order for it to work, your car simulation must display data in this format:

    car 42: 5 3 N
    car 95: 6 2 E
    car 64: 1 5 E

    car 42: 5 3 W
    car 95: 6 2 S
    car 64: 1 5 E

    car 42: 5 2 W
    car 95: 7 2 S
    car 64: 1 6 E

Specifically:
- Each line must start with `car [id]:`, _exactly as shown_.
- After the colon and space, display the car’s current street, current avenue, and current heading, separated by spaces.
- To indicate the end of a particular “snapshot,” display a blank line. So yes, the blank lines are required—otherwise, the simulation visualizer won’t know that the cars have changed state.

Finally, the simulation visualizer ignores all other output. This allows you to print out other data (e.g., the current time; the detection of a termination condition) for informational or debugging purposes.

#### Running the Simulation Visualizer
You have one more command line punctuation mark to learn in this assignment: the vertical bar or pipe (`|`). This symbol connects two programs together by sending the output of the command to its left into the command to its right, _as if it were typed in by the user_:

    java CarSimulation < cars-example.txt | java Town2D

The above command will run the car simulation using the _cars-example.txt_ file, displaying the simulation results (based on what `CarSimulation` prints out) in a window. To quit the visualizer, close the window.

#### Simulation Visualizer Options
The `Town2D` program accepts two command-line arguments: an interval and a “switch” for whether the simulation should display “tracks.” The interval is the delay between simulation updates, given in milliseconds. The program defaults to `1000`. Tracks are not displayed by default, but can be activated by providing a second argument of any value. Thus, the following command will run the simulation such that it waits two (2) seconds between updates and it retains data on where the cars have been:

    java CarSimulation < cars-example.txt | java Town2D 2000 track

_Caveat simulator:_ The `Town2D` program is meant to aid in running and debugging the simulation; it is not intended to be a fully-robust, end-user program. Thus, it may have bugs and might not handle all error conditions in an elegant or user-friendly way.

### “Interesting” Car Files
Once you are done with your simulation, it’s time to play with it! Come up with three (3) car files that result in “interesting” simulation runs. Explore the following scenarios:
- What is the longest single route that a car can take before it loops around to repeat its instructions?
- What are the longest routes that two cars can take without ever ending up on the same intersection at the same time?
- What kinds of instruction strings will let a car touch every intersection in town without repeating any?

Submit the car file itself, a Markdown file with some commentary on that car file, and a screenshot of the `Town2D` simulation run produced by that car file (with the “tracks” feature turned on). If you feel duly inspired, maybe you can even find a way to submit the image as a GIF showing the cars’ movements. Link to that file from within the Markdown document for easy reading ([look it up](https://guides.github.com/features/mastering-markdown/); it’s easy to do).

### Summary of Deliverables
In sum, you are asked to implement a discrete event simulation of a simple town/traffic/car model. Submit the following:
- A `Car` class that adheres to the API specification in the course website
- A `CarSimulation` class that builds on the starter file provided in the repository and behaves as specified in these instructions
- Three (3) “interesting cases” that produce simulation results with notable characteristics (three car files and three Markdown files linking to three screenshots)

Save them all in the GitHub repository that is given to you upon accepting the assignment.
