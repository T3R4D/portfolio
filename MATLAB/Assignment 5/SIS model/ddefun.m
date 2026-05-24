function dSISdt = ddefun(t, y, z)
% x(1) - Susceptible population, x(2) - infected population, x(3) -
% infectious population
% r - growth rate of population
% K - carrying capacity
% beta - transmission of infection
% gamma - recovery rate 
% mu - natural death rate
% delta - death rate due to infection
% delay - delay parameter

global r K beta gamma mu delta

dSISdt = [r*y(1)*(1-y(1)/K) - beta*y(1)*y(2)/(y(1)+y(2)) - mu*y(1) + gamma*y(2) + gamma*z(2); ...
    beta*z(1)*z(2)/(z(1)+z(2)) - (mu+gamma+delta)*z(2) - (mu + gamma + delta)*y(2)];

end
