function dSIRdt = sirfun(t, x)
% x(1) - Susceptible population, x(2) - Infected population, x(3) -
% Recovered population
% beta - transmission 
% gamma - recovery rate 
% mu - mortality rate

global beta gamma mu

dSIRdt = [-beta*(x(2)*x(1))/(x(1)+x(2)+x(3)); beta*x(2)*x(1)/(x(1)+x(2)+x(3)) - gamma*x(2) - mu*x(2); gamma*x(2)];

end
