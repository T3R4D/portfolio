clear;
global r K beta gamma mu  delta 
r = 0.2; % r - growth rate of population
K = 100; % K - carrying capacity
beta = 0.25; % beta - transmission of infection
gamma = 0.01; % gamma - recovery rate 
mu = 0.01; % mu - natural death rate
delta = 0.02; % delta - death rate due to infection

tspan = [0 1000];
n=10; 

delayspan1 = (10:10:100);

for i = 1:n
delay = delayspan1(i);
sol = dde23(@ddefun, delay, @history, tspan);
subplot(5,2,i)
plot(sol.x,sol.y);
title(['Delayed SIS model for ' num2str(delay)]);
xlabel('time');
ylabel('Number of People');
%legend('Susceptible','Infected');
end


