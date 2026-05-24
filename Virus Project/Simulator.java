import static java.lang.Math.*;
import java.io.*;
import java.util.*;

/**
 * Procedures for the simulator 
 */
class Simulator
{
    /**
     * Counts the number of infected agents in an array.
     * 
     * @param a the agent array to count from
     * @return the number of infected agents
     */
    static int countInfected(Agent[] a)
    {
        int n = a.length;
        int numberOfInfected = 0;
        
        for(int i = 0; i < n; i++)
        {
             if(AgentActions.isInfected(a[i]) == true)
             {
                numberOfInfected = numberOfInfected + 1;
             }
        }
        
        return numberOfInfected;
    }
    
    /**
     * Counts the number of infectious agents in an array.
     * 
     * @param a the agent array to count from
     * @return the number of infectious agents
     */
    static int countInfectious(Agent[] a)
    {
        int n = a.length;
        int numberOfInfectious = 0;
        
        for(int i = 0; i < n; i++)
        {
             if(AgentActions.isInfectious(a[i]) == true)
             {
                numberOfInfectious = numberOfInfectious + 1;
             }
        }
        
        return numberOfInfectious;
    }
    
    /**
     * Counts the number of immune agents in an array.
     * 
     * @param a the agent array to count from
     * @return the number of immune agents
     */
    static int countImmune(Agent[] a)
    {
        int n = a.length;
        int numberOfImmune = 0;
        
        for(int i = 0; i < n; i++)
        {
             if(AgentActions.isImmune(a[i]) == true)
             {
                numberOfImmune = numberOfImmune + 1;
             }
        }
        
        return numberOfImmune;
    }
    
    /**
     * Create an array of random agents.
     * 
     * @param n the amount of agents to create, assumed to be >=1
     * @param p the probability an agent becomes infected, assumed to be 
     * 0 <= p <= 1
     * @return an array of random agents 
     */
    static Agent[] randomAgents(int n, double p)
    {
        Agent[] a = new Agent[n];
                       
        for(int i = 0; i < n; i++)
        { 
            Agent x = new Agent();
            
            x.x = (int) floor(50*random());
            x.y = (int) floor(50*random());
            x.direction = (int) floor(4*random());
            x.timeAfterInfection = -1;
            
            if(p >= random())
            {
                x.timeAfterInfection = 0;
            }
            
            a[i] = x;    
        }
        
        return a;
    }
    
    /**
     * Computes one round of the simulation
     * 
     * @param a an array of agent records
     */
    static void oneRound(Agent[] a)
    {
        int n = a.length;
        
        //Step 1
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(a[i].x == a[j].y && a[i].y == a[j].y)
                {
                    if(AgentActions.isInfectious(a[i]) == true)
                    {
                        if(AgentActions.isInfectable(a[j]) == true)
                        {
                            AgentActions.infect(a[j]);
                        }
                    }
                }
            }
        }
        
        //Step 2
        for(int i = 0; i < n; i++)
        {
            
            AgentActions.move(a[i]);
            
        }
        
        //Step 3
        for(int i = 0; i < n; i++)
        {
            AgentActions.timeStep(a[i]);
        }
        
    }
    
    /**
     * Runs the simulation of the infectious disease
     * 
     * @param n the amount of agents to create, assumed to be >= 1
     * @param p the probability an agent becomes infected, assumed to be 
     * 0 <= p <= 1
     * @param r the number of rounds for the simulation to run, assume to be 
     * >= 1
     * @param filename the name of the file to store the data
     * 
     * @throws IOException If an input or output exception occurred
     */
    static void runSimulation(int n, double p, int r, String filename) 
    throws IOException
    {
        Agent[] a = randomAgents(n, p);
        
        File myFile = new File(filename);
        PrintStream s = new PrintStream(myFile);
        
        int infected = countInfected(a);
        int infectious = countInfectious(a);
        int immune = countImmune(a);
            
        s.println(0 + "," + infected + "," + infectious + "," + immune);
        
        for(int i = 1; i <= r; i++)
        {
            oneRound(a);
            
            infected = countInfected(a);
            infectious = countInfectious(a);
            immune = countImmune(a);
            
            s.println(i + "," + infected + "," + infectious + "," + immune);
        }
        
        s.close();
    }
}
