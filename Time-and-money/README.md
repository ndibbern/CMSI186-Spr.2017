**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0206
Okay, here we go—full-blown Java programming commences with this assignment. The idea here is that programming these in a language that you already know would be no problem (and in fact you might have programmed one or more of these already). It is the transition to Java which poses an additional challenge.

## Background Reading
At this point you will probably transition from reading the Java Tutorials through to using them primarily for reference:

http://docs.oracle.com/javase/tutorial/

Definitely feel free to do so, and consider using other documentation on that site to help you do your work, particularly the API documentation.

## Automated Feedback Setup
In order to connect your repository to our automated code review and feedback system, once you are up and running please send your repository’s URL to Ed Seim. You can either find him in person in the lab, tweet him at [https://twitter.com/SirSeim](https://twitter.com/SirSeim), or mention him in a GitHub comment (`SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

To assist you in development and as a source of further feedback, test programs are provided with this repository. The test programs test the supporting methods for each program but not the full command line invocations. You will be shown how to use these programs in class. The test programs will also be run automatically whenever you update your work on GitHub. _Make sure that the test program passes._ I have my own additional test program for making sure that all cases are covered.

_Points will be deducted if issues reported by the automated feedback system here linger in the final submission._

## Part 0: Commit Practice
We integrate, and score separately, a _commit practice_ component to this assignment. To acquaint you with a particular style of working with your code, we are “pre-scripting” the _first five commits_ of your work. The sequence is designed to show you how you can work gradually while maintaining source code that, although unfinished, can still compile and run.

This will make a little more sense after you’ve read the rest of the assignment. Go do that, then come back here.

OK, so now that you know what’s ahead, this is how you should start. The concept of a _stub_ is described in class:

1. Define _stubs_ of the methods being requested by the `DateCounter` class except for `main`. Commit. Note that at this point, _you should be able to successfully compile and run_ `DateCounterTestHarness`. You will get test failures, but the actual program execution sequence should work without any errors.
1. Create an empty `ChangeMaker` class. Commit. Here, you will be able to compile `ChangeMaker` but not yet `ChangeMakerTestHarness`.
1. Define _stubs_ of the methods being requested by the `ChangeMaker` class except for `main`. Commit. _Now_ you can compile both “Money”-related files, and you can run `ChangeMakerTestHarness`.
1. Add the `main` method to `DateCounter`. Commit. With this, you can now invoke `java DateCounter` without any errors, although it won’t do anything yet.
1. Add the `main` method to `ChangeMaker`. Commit. Similarly to above, with this you can now invoke `java ChangeMaker` without any errors.

This sequence is sometimes called “scaffolding”—it sets up the overall structures needed for the program without filling in the details of the program itself. Within this “scaffold,” you can then continue working, completing methods a step at a time, with each step maintaining source code that continues to compile and run. Rinse and repeat until the programs are complete.

## Part I: Time
Define a class called `DateCounter` and give it the following methods:
* `public static boolean isLeapYear(int year)` returns `true` if and only if the specified year is a leap year. _Do the requisite research to find the precise definition of a leap year in the Gregorian calendar._
* `public static int daysInMonth(int year, int month)` returns the number of days in the specified month.
* `public static boolean isValidDate(int year, int month, int day)` returns `true` if and only if the arguments constitute a valid date (examples of invalid dates include 2010-00-15, 2012-01-negative 5, 1700-02-29, 2001-03-32, 2014-04-31, etc.).
* `public static int daysBetween(int year0, int month0, int day0, int year1, int month1, int day1)` returns the absolute number of days between the two given dates. For example, `daysBetween(2000, 3, 1, 1999, 3, 1)` should return 366 and `daysBetween(1999, 3, 2, 2001, 5, 1)` should return 791. _The order in which the dates are specified is irrelevant._
* `public static int ageInDays(int birthyear, int birthmonth, int birthday)` returns how old (in days) a person with the given birthdate would be today. You are given a `today` method that returns the current year, month, and date in a 3-element `int` array. This code is a notch more advanced so you are expected to just use this code correctly; you are not expected to understand it.
* `public static void main(String[] args)` displays either the absolute number of days between two given dates (both given in year-month-day order) or the day-age of a person with the given birthdate (when only one year-month-day sequence is given).

Implement all of these methods _with your own code_. Do _not_ use utility or library classes. Use the `ChangeMakerTestHarness` program that is supplied with this assignment to test your methods against a selection of known cases.

### Additional Specifications
If the user does not supply any arguments, display the message:

    Usage: java DateCounter <one or two dates in year-month-day order>

If the user enters anything outside of the two possible sets of arguments, whether non-numbers, missing/excess arguments, or just invalid dates, display the message:

    One or more of the supplied dates is not valid.

### Sample Output
If the entered arguments are valid, display the appropriate answer depending on the number of arguments. For three arguments, display the age, in days, of a person born on that date. Thus, the output for:

    java DateCounter 1991 9 10

…would be:

    ## days old

(where `##` is the number of days—we can’t write that precise number here because that number will depend on when you run the program!)

For six arguments, display the absolute number of days between the dates. Thus, the output for:

    java DateCounter 1999 3 2 2001 5 1

…would be:

    791 days

## Part II: Money
Define a class called `ChangeMaker` and give it the following methods:
* `public static int getQuarters(int cents)` returns the number of quarters needed if you were providing change for the given amount in cents.
* `public static int getDimes(int cents)` returns the number of dimes needed.
* `public static int getNickels(int cents)` returns the number of nickels needed.
* `public static int getPennies(int cents)` returns the number of pennies needed…you get the idea.
* `public static int[] getCoins(int cents)` returns a 4-integer array indicating the number of coins needed to put together the given amount in cents. The first element should hold the number of quarters, the second element should hold the number of dimes, the third element should hold the number of nickels, and finally the fourth element should hold the number of pennies.
* `public static int getTotalCents(int[] coins)` returns the amount in cents represented by the 4-integer array of denominations. Observe how `getCoins` and `getTotalCents` are inverse operations, in a way: they convert one value to the other and back.
* `public static int[] joinCoins(int[] initialCoins, int[] additionalCoins)` returns a 4-integer array indicating the total number of coins for each denomination of `initialCoins` and `additionalCoins`.
* `public static void main(String[] args)` displays either the change to be made for the given amount in cents, the total in cents for a given set of denomination counts, or the total in coins and cents for two sets of denomination counts.

Implement all of these methods _with your own code_. Do _not_ use utility or library classes. Use the `DateCounterTestHarness` program that is supplied with this assignment to test your methods against a selection of known cases.

### Additional Specifications
If the user does not supply any arguments, display the message:

    Usage: java ChangeMaker <amount in cents | four coin counts | eight coin counts>

If the arguments are anything other than the supported variations—i.e., one, four, or eight numbers—display this usage message as well.

If the user enters a decimal number or any other non-integer, display the message:

    Supplied values must be integers.

If the user enters a negative integer, display the message:

    Negative amounts are not permitted.

### Sample Output
If the entered arguments are valid, display the appropriate answer depending on the number of arguments. For one argument, display the change required, one line per denomination. Thus, the output for:

    java ChangeMaker 146

…would be:

    Quarters: 5
    Dimes: 2
    Nickels: 0
    Pennies: 1

For four arguments, display the total represented by the coin counts, assumed to be given in the order of quarters, dimes, nickels, then pennies:

    java ChangeMaker 5 2 0 1

…would be:

    146 cents

For eight arguments, display the total represented by combining the coin counts, assumed to be given as two sequences of quarters, dimes, nickels, then pennies:

    java ChangeMaker 5 2 0 1 3 0 4 5

…would be:

    Quarters: 8
    Dimes: 2
    Nickels: 4
    Pennies: 6

    246 cents
