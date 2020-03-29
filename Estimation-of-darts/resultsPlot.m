M = csvread('resultsStepsof100.dat');
aproximation = M(:,1)';
nThrows = M(:,2)';
errorOfAproximation = abs(pi - aproximation);

ax1 = subplot(2,1,1);
plot(ax1,nThrows, errorOfAproximation, '-')
title(ax1,'Absolute error versus NThrows')
ylabel(ax1,'absolute error with real value of Pi')
xlabel(ax1,'Number of throws')


ax2 = subplot(2,1,2);
plot(ax2, nThrows, aproximation, '-');
title(ax2,'Approximated value of Pi vs NThrows')
ylabel(ax2,'Approximated value of Pi')
xlabel(ax2,'Number of throws')