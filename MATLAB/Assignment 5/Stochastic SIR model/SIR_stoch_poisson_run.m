function SIR_stoch_poisson_run

% input parameters
params.beta = 2; % transmission of infection
params.mu = 0.01; % mortality rate
params.gamma = 0.1; % recovery rate

% initial conditions
initial.S = 100; % susceptible people
initial.I = 1; % infected people
initial.R = 0; % recovered people

end_time = 100;

n=500; % number of runs


duration = zeros(n,1); 
sumduration = 0;
deaths = zeros(n,1);
sumdeaths = 0;
peaktime = zeros(n,1);
sumpeaktime = 0;
probindex = 0;

% conditions for deterministic
tspan = [0 100];
x0 = [100; 1; 0];
global beta mu gamma
beta = 2;
mu = 0.01;
gamma = 0.1;

for i = 1:n
    out = SIR_stoch_poisson(params, initial, end_time);
    result.time = [0 out.time];
    result.S = [initial.S out.S];
    result.I = [initial.I out.I];
    result.R = [initial.R out.R];
    if i == 1
        figure(i)
        plot (result.time, result.S,'b.-',result.time, result.I,'r.-',...
            result.time, result.R,'g.-');
        grid on
        title(['Stochastic SIR model']);
        xlabel ('time');
        ylabel ('Number of people');
        hold on
        [t,x] = ode45(@sirfun, tspan, x0);
        plot(t,x(:,1),'b--',t,x(:,2),'r--',t,x(:,3),'g--');
        legend ('stoch susceptible','stoch infected','stoch recovered', ...
            'det susceptible','det infected','det recovered');
    elseif i == 2
        figure(i)
        plot (result.time, result.S,'b.-',result.time, result.I,'r.-',...
            result.time, result.R,'g.-');
        grid on
        title(['Stochastic SIR model']);
        xlabel ('time');
        ylabel ('Number of people');
        hold on
        [t,x] = ode45(@sirfun, tspan, x0);
        plot(t,x(:,1),'b--',t,x(:,2),'r--',t,x(:,3),'g--');
        legend ('stoch susceptible','stoch infected','stoch recovered', ...
            'det susceptible','det infected','det recovered');
    elseif i == 3
        figure(i)
        plot (result.time, result.S,'b.-',result.time, result.I,'r.-',...
            result.time, result.R,'g.-');
        grid on
        title(['Stochastic SIR model']);
        xlabel ('time');
        ylabel ('Number of people');
        legend ('susceptible','infected','recovered');
    elseif i == 4
        figure(i)
        plot (result.time, result.S,'b.-',result.time, result.I,'r.-',...
            result.time, result.R,'g.-');
        grid on
        title(['Stochastic SIR model']);
        xlabel ('time');
        ylabel ('Number of people');
        legend ('susceptible','infected','recovered');
    end
    % part i
    index1 = find(result.I == 0, 1);
    duration(i) = result.time(index1);
    sumduration = sumduration + duration(i);
    % part ii
    deaths(i) = 101 - (result.S(end) + result.I(end) + result.R(end));
    sumdeaths = sumdeaths + deaths(i);
    % part iii
    maxinfected = max(result.I);
    index2 = find(result.I == maxinfected,1);
    peaktime(i) = result.time(index2);
    sumpeaktime = sumpeaktime + peaktime(i);
    % part iv
    if maxinfected > 10
        probindex = probindex+1;
    end
end

% i mean duration of the epidemic
meanduration = sumduration/n;
meanduration
figure(5)
histogram(duration);
title(['Histogram of the duration of the epidemic']);
xlabel ('Duration');
ylabel ('Frequency');

% ii mean total number of deaths
meandeath = sumdeaths/n;
meandeath
figure(6)
histogram(deaths);
title(['Histogram of the number of deaths']);
xlabel ('Number of Deaths');
ylabel ('Frequency');

% iii time needed max infected individuals
meanpeaktime = sumpeaktime/n;
meanpeaktime
figure(7)
histogram(peaktime);
title(['Histogram of time taken for maximum infected individuals']);
xlabel ('Duration');
ylabel ('Frequency');

%iv prob no infected > 10
probnuminfected = probindex/n * 100;
probnuminfected