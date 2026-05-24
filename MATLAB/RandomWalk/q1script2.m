%q1script.m
%computes M random walks then works out the index N_L for the number of steps
%needed to reach a distance of L=10

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
mm=(1:M)';

NL=zeros(M,1);

for q=1:M
    for r=1:N
        if distance(r,q)<10
            NL(q) = NL(q)+1;
        else
            break
        end
    end
end

NLmean = mean(NL,1);

y=zeros(M,1);
for s=1:M
    y(s)=NLmean;
end

NLmean

%%%%%%%%%%%%%% plots %%%%%%%%%%%%%%%%%%%%
figure(1); clf;
plot(mm,NL,'b-*',mm,y,'r'); %plots number of steps per person to be L=10 from the origin
grid;
xlabel('Person')
ylabel('Number of steps')
title('Number of steps needed to reach a distance of 10')
legend('Data points','Mean distance')
figure(2);clf;
histogram(NL); %plots a histogram
xlabel('Number of steps')
title('Histogram for number of steps needed to reach a distance of 10')