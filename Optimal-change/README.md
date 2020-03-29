**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0419
For our second-to-last paradigm, we revisit the old change-making problem with a new approach, known as _dynamic programming_. Of note: the “programming” in “dynamic programming” does not refer to the code that you write, but to the optimal solution (i.e., the “plan” or “program”) that is sought by the problem. It’s the same use of “programming” in _linear programming_, not _computer programming_.

## Background Reading
There’s more to the etymology of _dynamic programming_ than what is mentioned above; see the [History section](https://en.wikipedia.org/wiki/Dynamic_programming#History) of the [dynamic programming Wikipedia article](https://en.wikipedia.org/wiki/Dynamic_programming) for additional context that seems eerily resonant today.

## Automated Feedback Setup
In order to connect your repository to our automated code review and feedback system, once you are up and running please create a GitHub issue requesting this on your repository and mention Ed Seim in it (`@SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

You might recall that we have gone up a level with some best practices surrounding this work:

* _You are expected to write your own unit tests._ A starter suite is provided, but it does not cover all of the notable cases. Follow the pattern from the previous assignments. The automated system will now run _your_ tests and tell you how you fare. When grading, we do have our own suite of tests to ensure proper coverage.

* _You are expected to indent and format your code more strictly._ Deductions will accompany severe issues with code formatting/presentation. Please consult the [“Curly-Brace” Languages](http://lmucs.github.io/hacking-guidelines/curly/) section of the [LMU CS Hacking Guidelines](http://lmucs.github.io/hacking-guidelines/) site for details (a Java-specific page has not yet been constructed). The feedback system itself will also provide guidelines and notes on how to format your code.

Points will be deducted if issues reported by the automated feedback system here linger in the final submission.

## Dynamic Programming: Optimal Change-Making
Complete the supplied Java code by tracking down its failing tests and fixing them. We will leave it to you to determine what’s broken, but this should be pretty obvious after the in-class briefing on this assignment.

One method that needs to implemented for sure is the core method of the `MakeOptimalChange` class:

    public static Tally makeOptimalChange(int[] denominations, amount)

The returned `Tally` object should consist of the optimal way for making the given amount using the given denominations. When no such way exists, the returned value should be the special constant `Tally.IMPOSSIBLE` (also already defined for you).

To demonstrate the correctness of your implementation, add test cases to the supplied test harness. That test harness includes only the trivial example of standard change making using USA currency.

Short of the failing tests, the rest of the code has been written for you, both to decrease the time required to finish the assignment and to provide a demonstration of “how the teacher would have done it.” As with previously supplied code, feel free to study what’s in there.

### How to Use `MakeOptimalChange`
Invoke `MakeOptimalChange` like this:

    $ java MakeOptimalChange denominations amount

The `denominations` argument is a comma-separated list of integers without spaces between them; `amount` is the integer amount for which to make change. Sample runs are included below (to save space, the usage message is included only if it is the only output shown by the program):

    $ java MakeOptimalChange 2
    Usage: java MakeOptimalChange <denominations> <amount>
      - <denominations> is a comma-separated list of denominations (no spaces)
      - <amount> is the amount for which to make change

    $ java MakeOptimalChange huh wut
    Denominations and amount must all be integers.

    $ java MakeOptimalChange 9,10 -4
    Change cannot be made for negative amounts.

    $ java MakeOptimalChange 0,5,9 32
    Denominations must all be greater than zero.

    $ java MakeOptimalChange 0, 5, 9 32
    Usage: java MakeOptimalChange <denominations> <amount>
      - <denominations> is a comma-separated list of denominations (no spaces)
      - <amount> is the amount for which to make change

    $ java MakeOptimalChange 10,1,10,14 28
    Duplicate denominations are not allowed.

    $ java MakeOptimalChange 10,1,14 28
    28 cents can be made with 2 coins as follows:
    - 0 10-cent coins
    - 0 1-cent coins
    - 2 14-cent coins

    $ java MakeOptimalChange 2,16,8 5
    It is impossible to make 5 cents with those denominations.

    $ java MakeOptimalChange 4,1,9 12
    12 cents can be made with 3 coins as follows:
    - 3 4-cent coins
    - 0 1-cent coins
    - 0 9-cent coins

    $ java MakeOptimalChange 25,10,5,1 99
    99 cents can be made with 9 coins as follows:
    - 3 25-cent coins
    - 2 10-cent coins
    - 0 5-cent coins
    - 4 1-cent coins

### Implementation Notes
- The initial code that needs to be fixed is very similar to code that you’ve written before. (_Hint:_ What past assignment sought to do something very similar to what `MakeOptimalChange` is trying to do?)
- It’s all about the mantra given in class, given in class, given in class (no shortcuts). Make sure you have the mantra down cold.
- A helper method that is not included, but which you might find useful, is a `displayTable` helper. This will allow you to inspect the state of the solution table while the program is running.
- The denominations do not have to be sorted (and your code should not sort them, either).
- A one-cent denomination is not required; thus, the “no answer” case is certainly possible.
- There may be more than one optimal solution (i.e., a tie); in this case, the program may display any optimal solution.
