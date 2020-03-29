**CMSI 186-03** Programming Laboratory, Spring 2017

# Assignment 0410
Don’t let the quick turnaround startle you—I figured you can all use a quick breather after Intzilla. This assignment is merely about cleaning up something you’ve already done—the π estimator, which we did “live” last π Day.

## Randomized Estimation: Dart-Throwing for π
Copy the π estimator program that was written on March 14 into this repository. Build on the program you wrote back then by doing the following (presumably minor) improvements:
- Allow your estimator to accept the number of darts to throw as a command-line argument—some of you did this on your own, and if you did, good for you! If not, this should be straightforward and quite doable in a week.
- Clean up your code according to the code formatting standards that you first saw in Intzilla.
- That’s it! For convenience, the Dartboard program used for visualizing your darts is included in this repository, although you don’t necessarily need it to do the requested work.

## Estimation Exploration
Now that your estimator can easily run with varying numbers of darts, close out this exercise by running your estimator multiple times with different quantities of darts. Also, make sure that you run each quantity multiple times, because the darts are randomized after all.

Use these runs to answer the following questions:
1. In general, how many additional darts does it take to get _one additional decimal place of accuracy_ in your π estimation? Provide evidence for your answer in the form of your estimation output—no need for individual darts but just the final value and the number of darts used.
2. Do you think there is a point of diminishing returns where it isn’t worth the increase in darts in order to get an additional decimal place? At how many darts and decimal places do you reach this point?

Submit an _estimations.md_ file that lists your answers to these questions, along with any copied output that supports your answers.

## Automated Feedback Setup
As before, do connect your repository to our automated code review and feedback system. Create a GitHub issue requesting this on your repository and mention Ed Seim in it (`@SirSeim`). Once he has you hooked up, the system will provide feedback on code formatting and quality whenever you commit a new version to GitHub.

As always, _points will be deducted if issues reported by the automated feedback system here linger in the final submission_.
