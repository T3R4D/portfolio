
/**
 * Composite Data Type Agent
 * */
class Agent
{
    
    /**
     * Current x position on the board 
     */
    int x;
    
    /**
     * Current y position on the board
     */
    int y;
    
    /**
     * The agents current direction of movement
     * 0 = left, 1 = right, 2 = down, 3 = up
     */
    int direction;
    
    /**
     * The number of rounds after the agent has been infected
     * 0 newly infected 
     * , -1 never been infected or no longer immune
     */
    int timeAfterInfection;
    
}
