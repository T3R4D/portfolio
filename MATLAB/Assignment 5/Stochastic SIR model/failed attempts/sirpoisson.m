%simple_death.m
clear
n = 100;
m=100;
duration = zeros(n,1);
sumduration = 0;
deaths = zeros(n,1);
sumdeaths = 0;
peaktime = zeros(n,1);
sumpeaktime = 0;
probindex = 0;
vaccine = zeros(m,1);
initialS = 100;
initialI = 1;
initialR = 0;
for j = 1:m
    for i = 1:n
        beta = 2; gamma = 0.1; mu = 0.01;
        t1 = 0; S1 = initialS; I1 = initialI; R1 = initialR;
        S = initialS; I = initialI; R = initialR; t = 0;
        N=101;
        tspan = [0 100];
        x0 = [100; 1; 0];
        while t<100
            Inew = beta*S*I/N;
            expRV1 = -log(rand(1))/Inew;
            Dnew = mu*I;
            expRV2 = -log(rand(1))/Dnew;
            Rnew = gamma*I;
            expRV3 = -log(rand(1))/Rnew;
            if expRV1<expRV2
                if expRV1<expRV3
                    t = t+expRV1;
                    t1 = [t1 t];
                    S = S - 1;
                    S1 = [S1 S];
                    I = I + 1;
                    I1 = [I1, I];
                    R = R;
                    R1 = [R1,R];
                    N = S+I+R;
                else
                    t = t+expRV3;
                    t1 = [t1 t];
                    S = S;
                    S1 = [S1 S];
                    I = I - 1;
                    I1 = [I1, I];
                    R = R + 1;
                    R1 = [R1,R];
                    N = S+I+R;
                end
            else
                if expRV2<expRV3
                    t = t+expRV2;
                    t1 = [t1 t];
                    S = S;
                    S1 = [S1 S];
                    I = I - 1;
                    I1 = [I1, I];
                    R = R;
                    R1 = [R1,R];
                    N = S+I+R;
                else
                    t=t+expRV3;
                    t1 = [t1 t];
                    S=S;
                    S1=[S1 S];
                    I = I-1;
                    I1=[I1, I];
                    R = R+1;
                    R1=[R1,R];
                    N = S+I+R;
                end
            end
        end
        if i == 1 && j==1
            figure(i); clf;
            plot(t1,S1, 'b.-', t1, I1, 'r.-', t1, R1,'g.-')
            grid;
            xlabel('t');
            title(['Stochastic SIR model']);
            xlabel ('time');
            ylabel ('Number of people');
            hold on
            [t,x] = ode45(@sirfun, tspan, x0);
            plot(t,x(:,1),'b--',t,x(:,2),'r--',t,x(:,3),'g--');
            legend ('stoch susceptible','stoch infected','stoch recovered', ...
                'det susceptible','det infected','det recovered');
        elseif i == 2 && j==1
            figure(i); clf;
            plot(t1,S1, 'b.-', t1, I1, 'r.-', t1, R1,'g.-')
            grid;
            xlabel('t');
            title(['Stochastic SIR model']);
            xlabel ('time');
            ylabel ('Number of people');
            hold on
            [t,x] = ode45(@sirfun, tspan, x0);
            plot(t,x(:,1),'b--',t,x(:,2),'r--',t,x(:,3),'g--');
            legend ('stoch susceptible','stoch infected','stoch recovered', ...
                'det susceptible','det infected','det recovered');
        end
        % i
        index1 = find(I1 == 0, 1);
        duration(i) = t1(index1);
        sumduration = sumduration + duration(i);
        % ii
        deaths(i) = 101 - (S1(end) + I1(end) + R1(end));
        sumdeaths = sumdeaths + deaths(i);
        % iii
        maxinfected = max(I1);
        index2 = find(I1 == maxinfected,1);
        peaktime(i) = t1(index2);
        sumpeaktime = sumpeaktime + peaktime(i);
        % iv
        if maxinfected > 10
            probindex = probindex+1;
        end
    end
    if j == 1
        % i mean duration of the epidemic
        meanduration = sumduration/n;
        figure(3)
        histogram(duration);
        title('Histogram of the duration of the epidemic');
        xlabel ('Duration');
        ylabel ('Frequency');
        xline(meanduration, 'r--', 'Mean duration');

        % ii mean total number of deaths
        meandeath = sumdeaths/n;
        figure(4)
        histogram(deaths);
        title('Histogram of the number of deaths');
        xlabel ('Number of Deaths');
        ylabel ('Frequency');
        xline(meandeath, 'r--', 'Mean number of deaths');

        % iii time needed max infected individuals
        meanpeaktime = sumpeaktime/n;
        figure(5)
        histogram(peaktime);
        title('Histogram of time taken for maximum infected individuals');
        xlabel ('Duration');
        ylabel ('Frequency');
        xline(meanpeaktime, 'r--', 'Mean peak time');

        %iv prob no infected > 10
        probnoinfected = probindex/n * 100;
        probnoinfected
    end
    initial.S = initialS-1;
    initial.R = initialR+1;
    vaccine(j) = probindex/n*100;
    probindex = 0;
end

line = vaccine(1)/2;
index3 = find(vaccine <= line, 1);
% v prob no infected > 10
mm = 1:1:m;
figure(6)
plot(mm,vaccine);
yline(line, 'r--', 'Threshold');
title(['Graph with threshold at ' num2str(line)]);
xlabel ('Number of vaccinated people');
ylabel ('Probability');