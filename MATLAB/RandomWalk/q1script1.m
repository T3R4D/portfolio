%q1script.m
%computes M random walks, the mean Euclidean distance and variance of those
%walks and the probability that the distance is greater than 10

N=500; %number of steps
M=100; %number of random walks
x=zeros(N+1,M);  %column i is a vector of the coordinates of the i-th walker
dx=rand(N,M);
for i=1:N
    for j=1:M
        if dx(i,j)<0.25
            dx(i,j) = 1;
        elseif dx(i,j)>0.25 && dx(i,j)<0.5
            dx(i,j) = -1;
        elseif dx(i,j)>0.5 && dx(i,j)<0.75
            dx(i,j) = 1i;
        else
            dx(i,j) =-1i;
        end
    end
end

for k=1:N
    x(k+1,:)=x(k,:)+dx(k,:);
end

%euclidean distance
distance=zeros(N+1,M);
for p=1:N+1
    distance(p,:)=abs(x(p,:));
end

nn=(0:N)';
mm=(0:M)';

Ex=mean(distance,2); %mean of the euclidean distance
Vx=var(distance,1,2); %variance over all walks 

%probability
Px=zeros(1,N+1); 
for q=1:N
    for r=1:M
        if distance(q,r)<10
        Px(1,q) = Px(1,q)+1;
        end
    end
end
PL = Px/M;
Px_theoretical = 1 - exp(-(10^2)./nn);

%print values of probabilities
PL(end-1)
Px_theoretical(end-1)

%%%%%%%%%%%%%% plots %%%%%%%%%%%%%%%%%%%%
figure(1); clf;
plot(nn,Ex); %plots expectation
grid;
xlabel('Number of steps');
ylabel('Euclidean distance expectation')
title(['Expected distance of random walk for ', num2str(N), ' steps']);
figure(2); clf;
plot(nn,Vx); %plots variance
grid;
xlabel('Number of steps');
ylabel('Variance')
title(['Variance for distance of random walk for ', num2str(N), ' steps']);
figure(3); clf;
plot(real(x(:,1)),imag(x(:,1)),'b.-',real(x(:,2)),imag(x(:,2)),'r.-'); %plot 2 samples of random walk
grid;
xlabel('x');
ylabel('y'); 
title(['2 random walks for ', num2str(N), ' steps']);
legend('Person 1','Person 2');
figure(4); clf;
plot(nn,PL,'b.-',nn,Px_theoretical,'r.-'); %plot probability of being less than distance of 10 from origin
grid;
xlabel('Number of steps');
ylabel('Probability');
title(['Probaility of being less than a distance of 10 from the origin']);
legend('Real', 'Theoretical')