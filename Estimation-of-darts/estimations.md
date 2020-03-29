# CMSI186-Spr.2017

## Report HW 5

### Estimation of π:

Bellow one can find some plots that represent how the value of π becomes more
accurate as the number of throws increases:

![My Terminal](https://github.com/lmu-cmsi186-spring2017/estimation-by-darts-ndibbern/blob/master/plots.jpg)

From the above plot, it can be seen how the error decreases rapidly during the
first 2000 throws.

Bellow is a closer look to the plot that represents throws from 1 to 1000

![My Terminal](https://github.com/lmu-cmsi186-spring2017/estimation-by-darts-ndibbern/blob/master/resultsUpTo1000Throws.jpg)

Again, in this plot is even more evident how the value of pi approximates to the
real value with a good accuracy after the first 2000 throws.

It is important to note that given the oscillation of the values around the real value of
π, the approximation does not increase necessarily at each consecutive step. however, it is seen
that the graph monotonically decreases its error with respect to the real value of π.
This is clearly due to the randomization (i.e  1000 throws might be more accurate
than 1001 just due to randomization).

Below one can find a plot now that represents the values of throws from 1 to 2000 with steps of 100

![My Terminal](https://github.com/lmu-cmsi186-spring2017/estimation-by-darts-ndibbern/blob/master/resultsStepsof100.jpg
)

Again, it is clear here to see that after 2000 steps, the value of pi is better approximated of course, but does not vary
as much as it did on the first few steps. Because of that, it is fair to say that at this point, it is not worth increasing
the number of darts. It is true, that as increasing the darts the value of pi will still increase, but in comparison
to the computational time it might not be efficient.

It is importante to notice though, that an accurate result is found at 10000 throws:

    Natalias-MacBook-Pro:estimation-by-darts-ndibbern ndibbern$ java PiEstimator 10000
    3.1464

However, from the plots it can be seen how this extra long it takes to reach that point.

When determining how many more darts are needed in order to increment one level of accuracy in the results,
it is very hard to say. Again, due to randomization, the accuracy of the results do not necessarily increase
after each step. Because of this reason we produce the graph from below:

![My Terminal](https://github.com/lmu-cmsi186-spring2017/estimation-by-darts-ndibbern/blob/master/AbsoluteErrorGridMathematica.png
)



In this graph one can find one more time the absolute error. It is seen how this decreases with the
number of steps. In the graph one can also find a grid that represents that every 100 steps, the accuracy increases
by 0.01.



(results for plots can be found under resultsStepsof100.dat , results.dat and resultsUpTo1000Throws.dat)
