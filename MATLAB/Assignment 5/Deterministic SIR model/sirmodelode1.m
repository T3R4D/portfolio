%Deterministic SIR model of epidemic
clear;
global beta gamma mu 
beta = 1; % transmission of infection 
gamma = 0.1; % recover rate
mu = 0.01; % mortality rate

tspan = [0 100];

x0 = [100; 1;  0];

[t, x] = ode45(@sirfun, tspan, x0);
figure(1); clf;
plot(t,x(:,1),'b-',t,x(:,2),'r-',t,x(:,3),'g-');

title(['Deterministic SIR model of epidemic']);
xlabel('t');
ylabel('Number of people');

legend('Susceptible Individuals','Infected Individuals','Recovered Individuals');