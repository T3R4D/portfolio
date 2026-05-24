function result = SIR_stoch_poisson(params, initial, end_time)
% Simulation of the stochastic SIR model 
% modified to include immigration

state = initial; % holds the state variables S, I and R


result.time = []; % receives the time results
result.S = [];    % receives the S results
result.I = [];    % receives the I results
result.R = [];    % receives the R results

time = 0;

%while (time < end_time && state.I > 0)
while (time < end_time)
        
    % calculate process probabilities for current state
    probs = probablities(state, params);

    % WHEN does the next process happen?
    tau = -log(rand(1))/sum(probs);
    
    %update time
    time = time + tau;
    
    % determine WHICH process happens after tau
    which = process(probs);
    
    % update state
    switch which
        case 1
            state.S = state.S - 1;
            state.I = state.I + 1;
        case 2
            state.I = state.I - 1;
        case 3
            state.R = state.R + 1;
            state.I = state.I - 1;
    end
    
    % store results
    result.time = [result.time time];
    result.S = [result.S state.S];
    result.I = [result.I state.I];
    result.R = [result.R state.R];
    
end


function which = process (probs)
% Determines which process happens

r = rand * sum(probs);
which = 1;
s = probs(1);
while (r > s)
    which = which + 1;
    s = s + probs(which);
end


function a = probablities (state, params)
% Calculates process probabilities for given state and parameters

a(1) = params.beta * (state.S * state.I)/(state.S + state.I + state.R); % infection of susceptibles
a(2) = params.mu* state.I; % death of susceptible individuals
a(3) = params.gamma * state.I; % recovery of infected individuals
