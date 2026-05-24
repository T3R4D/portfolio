%SIS model of infection with logistic growth  
clear;
global r K beta gamma mu  delta
r = 0.2; % r - growth rate of population
K = 100; % K - carrying capacity
beta = 0.25; % beta - transmission of infection
gamma = 0.01; % gamma - recovery rate 
mu = 0.01; % mu - natural death rate
delta = 0.02; % delta - death rate due to infection

tspan = [0 500];

x0 = [100; 1];

[t, x] = ode45(@sisfun, tspan, x0);
figure(1); clf;
plot(t,x(:,1),'b-',t,x(:,2),'r-');

title(['SIS model of infection with logistic growth']);
xlabel('t');
ylabel('Number of people');
legend('Susceptible individuals','Infected individuals');