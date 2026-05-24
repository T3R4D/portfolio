function dSISdt = sisfun(t, x)
% x(1) - Susceptible population, x(2) - infected population
% r - growth rate of population
% K - carrying capacity
% beta - transmission of infection
% gamma - recovery rate 
% mu - natural death rate
% delta - death rate due to infection

global r K beta gamma mu delta

dSISdt = [r*x(1)*(1-x(1)/K) - beta*x(2)*x(1)/(x(1)+x(2)) - mu*x(1) + gamma*x(2); ...
    beta*x(2)*x(1)/(x(1)+x(2)) - (mu + gamma + delta)*x(2)];

end
