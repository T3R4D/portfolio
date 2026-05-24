/**
 * Functions and procedures that act on agents
 */

class AgentActions
{
    /**
     * Checks whether an agent is infected.
     * 
     * @param a the agent to act on
     * @return true if the agent is infected, false if they are not infected 
     */
    
    static boolean isInfected(Agent a)
    {
        
        if (a.timeAfterInfection >= 0 && a.timeAfterInfection <= 13)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /**
     * Checks whether an agent is infectable.
     * 
     * @param a the agent to act on
     * @return true if the agent is infectable, false if they are not 
     * infectable 
     */
    static boolean isInfectable(Agent a)
    {
        
        if(a.timeAfterInfection == -1)
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }
    
    /**
     * Checks whether an agent is infectious.
     * 
     * @param a the agent to act on
     * @return true if the agent is infectious, false if they are not 
     * infectious 
     */
    static boolean isInfectious(Agent a)
    {
         
        if(a.timeAfterInfection >= 6 && a.timeAfterInfection <= 13)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /**
     * Checks whether an agent is immune.
     * 
     * @param a the agent to act on
     * @return true if the agent is immune, false if they are not immune 
     */
    static boolean isImmune(Agent a)
    {
         
        if(a.timeAfterInfection >= 14 && a.timeAfterInfection <= 60)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /**
     * Moves an agent.
     * 
     * @param a the agent to act on
     */
    static void move(Agent a)
    {
        
        if(a.direction == 0)
        {
            a.x = a.x - 1;
            if(a.x == -1)
            {
                a.direction = 1;
                a.x = a.x + 2;
            }
        }
        else if(a.direction == 1)
        {
            a.x = a.x + 1;
            if(a.x == 50)
            {
                a.direction = 0;
                a.x = a.x - 2;
            }  
        }
        else if(a.direction == 2)
        {
            a.y = a.y - 1;
            if(a.y == -1)
            {
                a.direction = 3;
                a.y = a.y + 2;
            }
        }
        else if(a.direction == 3)
        {
            a.y = a.y + 1;
            if(a.y == 50)
            {
                a.direction = 2;
                a.y = a.y - 2;
            }
        }
        
    }
    
    /**
     * Changes the timeAfterInfection data.
     * 
     * @param a the agent to act on
     */
    static void timeStep(Agent a)
    {
        
        if(a.timeAfterInfection != -1)
        {
            a.timeAfterInfection = a.timeAfterInfection + 1;
            if(a.timeAfterInfection == 61)
            {
                a.timeAfterInfection = -1;
            }
        }
        
    }
    
    /**
     * Infects an agent.
     * 
     * @param a the agent to act on
     */
    static void infect(Agent a)
    {
        a.timeAfterInfection = 0;
    }
    
}
