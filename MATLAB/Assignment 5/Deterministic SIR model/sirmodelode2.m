clear;
global gamma mu beta
gamma = 0.1; % recovery rate
mu = 0.01; % mortality rate
beta = 1; % transmission of infection
N = 25; %number of beta values


betaspan = (1:1:N);

tspan = [0 100];

x0 = [100; 1;  0];

deaths = zeros(N,1);

plot1 = randi(N);
plot2 = randi(N);
plot3 = randi(N);
plot4 = randi(N);

j = 1;

for i = 1:N
    beta = betaspan(i);
    [t, x] = ode45(@sirfun, tspan, x0);
    deaths(i) = 101-x(end,3);
    if i == plot1
        figure(1)
        subplot(2,2,j);
        plot(t,x(:,1),'b-',t,x(:,2),'r-',t,x(:,3),'g-');
        title(['SIR model when \beta =' num2str(beta)]);
        j=j+1;
    elseif i == plot2
        subplot(2,2,j);
        plot(t,x(:,1),'b-',t,x(:,2),'r-',t,x(:,3),'g-');
        title(['SIR model when \beta =' num2str(beta)]);
        j=j+1;
    elseif i == plot3
        subplot(2,2,j);
        plot(t,x(:,1),'b-',t,x(:,2),'r-',t,x(:,3),'g-');
        title(['SIR model when \beta =' num2str(beta)]);
        j=j+1;
    elseif i == plot4
        subplot(2,2,j);
        plot(t,x(:,1),'b-',t,x(:,2),'r-',t,x(:,3),'g-');
        title(['SIR model when \beta =' num2str(beta)]);
        j=j+1;
    end
end

figure(2);clf;
plot(betaspan,deaths,'b-o');
title(['Number of deaths depending on \beta value']);
xlabel('\beta value');
ylabel('Number of deaths');

