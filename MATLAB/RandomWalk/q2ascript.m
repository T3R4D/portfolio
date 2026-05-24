%q2ascript.m
%with epsilon = 0.1 

r = 1; K = 1; epsilon = 0.1; %problem parameters
T = 20; Nzero = 0.25; %conditions

M = 2^8;
dt = T/M;

dW = sqrt(dt)*rand(1,M); %Brownian increments
W=cumsum(dW); %discretized Brownina path

R = 4; Dt = R*dt; L=M/R; %L EM steps of size Dt = R*dt
Nem = zeros(1,L);
Ntemp = Nzero;

for j =1:L
    Winc = sum(dW(R*(j-1)+1:R*j));
    Ntemp = Ntemp + Dt*r*Ntemp*(1-Ntemp/K)+epsilon*Ntemp*Winc;
    Nem(j) = Ntemp;
end

plot([0:Dt:T],[Nzero,Nem],'r');
xlabel('t, time');
ylabel('N, population density');
hold on

%and with epsilon = 0.3

r = 1; K = 1; epsilon = 0.3; %problem parameters
T = 20; Nzero = 0.25; %conditions

M = 2^8;
dt = T/M;

dW = sqrt(dt)*rand(1,M); %Brownian increments
W=cumsum(dW); %discretized Brownina path

R = 4; Dt = R*dt; L=M/R; %L EM steps of size Dt = R*dt
Nem = zeros(1,L);
Ntemp = Nzero;

for j =1:L
    Winc = sum(dW(R*(j-1)+1:R*j));
    Ntemp = Ntemp + Dt*r*Ntemp*(1-Ntemp/K)+epsilon*Ntemp*Winc;
    Nem(j) = Ntemp;
end

plot([0:Dt:T],[Nzero,Nem],'b');
legend('\epsilon = 0.1', '\epsilon = 0.3')
hold off