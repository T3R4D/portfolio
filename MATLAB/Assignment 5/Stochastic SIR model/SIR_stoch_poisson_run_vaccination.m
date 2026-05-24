function SIR_stoch_poisson_run_vaccination

% input parameters
params.beta = 2; % transmission of infection
params.mu = 0.01; % mortality rate
params.gamma = 0.1; % recovery rate

% initial conditions
initial.S = 100; % susceptible people
initial.I = 1; % infected people
initial.R = 0; % recovered people

end_time = 100;

n=500; %number of runs
m = 100; %vaccine count
probindex = 0;
vaccine = zeros(m,1);

for j = 1:m
    for i = 1:n
        out = SIR_stoch_poisson(params, initial, end_time);
        result.time = [0 out.time];
        result.S = [initial.S out.S];
        result.I = [initial.I out.I];
        result.R = [initial.R out.R];
        % part v
        maxinfected = max(result.I);
        if maxinfected > 10
            probindex = probindex+1;
        else
            probindex = probindex;
        end
    end
    initial.S = initial.S-1;
    initial.R = initial.R+1;
    vaccine(j) = probindex/n*100;
    probindex = 0;
end

line = vaccine(1)/2;
index3 = find(vaccine <= line, 1)
% v prob no infected > 10
mm = 1:1:m;
figure(1)
plot(mm,vaccine);
yline(line, 'r--', 'Threshold');
title(['Graph with threshold at ' num2str(line)]);
xlabel ('Number of vaccinated people');
ylabel ('Probability');