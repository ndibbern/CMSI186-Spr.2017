**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0220
This assignment is partway between the transition from Java and the deeper computational characteristics of a “full 186” program. For Java, we focus on introducing you to object-oriented programming. For computation, you get a taste of what it means to run “experiments” on a computer.

## Background Reading
We remain within the Java tutorial here but are now particularly focused on classes and objects—features that, perhaps more than any other feature, give Java its particular personality (for better or worse). First, read about _objects_ and _classes_ here:

http://docs.oracle.com/javase/tutorial/java/concepts/index.html

Then, you can get into further detail here, _except_ for nested classes:

http://docs.oracle.com/javase/tutorial/java/javaOO/index.html

Make sure that, between these tutorial sections and the provided starter code, you come out of this assignment with a solid understanding of basic object-oriented programming in Java.

## Automated Feedback Setup
In order to connect your repository to our automated code review and feedback system, once you are up and running please send your repository’s URL to Ed Seim. You can either find him in person in the lab, tweet him at [https://twitter.com/SirSeim](https://twitter.com/SirSeim), or create a GitHub issue on your repository and mention him in it (`@SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

To assist you in development and as a source of further feedback, test programs are provided with this repository. The test programs test the supporting methods for each program but not the full command line invocations. You will be shown how to use these programs in class. The test programs will also be run automatically whenever you update your work on GitHub. _Make sure that the test program passes._ I have my own additional test program for making sure that all cases are covered.

_Points will be deducted if issues reported by the automated feedback system here linger in the final submission._

## Classes and Objects: Game of Coins
OK, let’s get this out right away: this isn’t _quite_ a game, but we hope you’ll still find it fun. For this program, you are asked to simulate a _bag of coins_. Further, the coins in this bag can be _biased_, meaning that they can be rigged so that the chances of producing heads vs. tails can be made to be _other_ than 50-50.

Once you have a working simulation for a bag of coins, you will be asked to explore different bags of different sizes and different bias values by “throwing” the bags into the air and tracking whether the coins land as heads or tails. The results of these experiments shall be displayed as “ASCII art” bar graphs indicating how frequently each coin landed as heads vs. tails.

### Building Blocks
You are given a fully implemented `Coin` class, to serve as both a building block for your code to use and as an example for how a typical Java class can be programmed. A `CoinTestHarness` is also provided, serving not only as a way to test the correctness of the `Coin` code but as an example for how Java classes are used.

You are asked to write `BagOfCoins` from scratch. This is to be a new Java class, to be saved under the name _BagOfCoins.java_, with the constructors and methods specified in the [_Javadoc_ pages](http://myweb.lmu.edu/dondi/spring2017/cmsi186/bag-of-coins) available at the course website. `BagOfCoins` should use `Coin` to help implement its functionality. A `BagOfCoinsTestHarness` class is provided, against which you can verify the correctness of your implementation.

### End-User Application
Once you have `BagOfCoins` written, it’s time to let command-line users play with it. Write a class called `AlexanderHamilton` whose `main` method creates a `BagOfCoins`, “throws” the coins in the bag multiple times, then displays the results of these throws as an “ASCII art” bar graph. The bar graph should be a _histogram_ showing how many coins flipped as heads at a certain frequency. To save space, the histogram may skip partitions that have zero coins. For example:

    $ java AlexanderHamilton
    450-459  * 3 coins
    460-469  * 19 coins
    470-479  **** 59 coins
    480-489  ************* 171 coins
    490-499  ******************* 248 coins
    500-509  ****************** 228 coins
    510-519  ************* 166 coins
    520-529  ***** 73 coins
    530-539  ** 27 coins
    540-549  * 5 coins
    550-559  * 1 coins

The default invocation of `AlexanderHamilton` should throw a bag of 1000 _fair_ coins (50-50 heads vs. tails) 1000 times, producing a histogram of 100 partitions. In the example above, this particular run yielded three (3) coins that came up as heads between 450-459 times out of the 1000 throws. 248 coins came up as heads between 490-499 times out of 1000 throws—generally expected given that these coins are unbiased.

Contrast that with this run, where we have the exact same experiment but use _biased_ coins of 0.25. In other words, tails will generally come up at only a 25-75 ratio:

    $ java AlexanderHamilton - - - 0.25
    710-719  * 18 coins
    720-729  **** 51 coins
    730-739  *********** 145 coins
    740-749  ******************** 259 coins
    750-759  *********************** 292 coins
    760-769  ************ 158 coins
    770-779  **** 59 coins
    780-789  * 14 coins
    790-799  * 3 coins
    800-809  * 1 coins

Notice that here, all of the coins came up as heads between 710 and 809 times out of the 1000 throws—quite a difference from the fair coins. The most common frequency is 750-759 occurrences of heads—292 coins behaved this way.

### Additional Specifications
`AlexanderHamilton` should accept either zero (0) or four (4) command-line arguments. When 0 arguments are given, `AlexanderHamilton` should perform a default run of 1000 fair coins thrown into air 1000 times, displaying the results in a histogram consisting of 100 partitions.

When four (4) arguments are given, the user can customize the number of coins, the number of throws, the number of partitions, and the coin bias. The first three arguments should be positive integers and the fourth argument may have a decimal value. In addition, `AlexanderHamilton` should allow a dash (`-`) in an argument slot, indicating that the user would like the default value for that argument. For example:

    $ java AlexanderHamilton 10000 - - 0.25

…means that the user would like to have a bag of _10,000_ coins, all with a bias of 0.25. However the bag is to be thrown by the default number of times (1000) with the results displayed in the default number of histogram partitions (100).

Erroneous arguments in any form should be met with an appropriate error message, and _not_ a Java exception. `AlexanderHamilton` must also display an error message in the special case where the number of partitions does not evenly divide the number of throws.

You might notice that we can write a _lot_ more programs that use `Coin` and `BagOfCoins` than just `AlexanderHamilton`. But that’s the point: in a world of classes and objects, one can now imagine a codebase as being made of parts that a programmer can put together in different ways. What other interesting programs can you envision writing with `Coin` and `BagOfCoins`?

### Bag-Throwing Experiments
As a non-code deliverable, once `AlexanderHamilton` is finished, invoke it using at least ten (10) different combinations of coin count, throw count, partition count, and bias. Copy-paste the results in a file called _experiments.md_. _.md_ stands for _Markdown_—an easy-to-use text format for producing clean-looking web documents. You can examine the source code of these very instructions to learn some Markdown; you can also consult [GitHub’s Markdown page](https://guides.github.com/features/mastering-markdown/), among others that can be found on the web.

Accompany the copy-pasted histograms with commentary on what the different experiments demonstrate. Use any knowledge that you already have about probability and statistics to design the experiments and discuss the results.

### Summary of Deliverables
Phew! That seems like a lot to do but it’s mostly explanation. Here’s a summary:

- Write `BagOfCoins` according to the specifications given [on the course website](http://myweb.lmu.edu/dondi/spring2017/cmsi186/bag-of-coins)
- Write `AlexanderHamilton` according to the specifications given on these instructions
- Document ten (10) or more experiments with `AlexanderHamilton` in a file called _experiments.txt_.

Save them all in the GitHub repository that is given to you upon accepting the assignment.
