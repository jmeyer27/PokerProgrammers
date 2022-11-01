import java.util.ArrayList;
import java.util.*;
import java.lang.String;
import java.util.Arrays;
/**
 * Counts the occurances of a rank.
 *
 * @author (Sophia Nguyen)
 * @version (4/25/19)
 */

public class CountRank
{
    private int rankCount[];
    public static final int CARDS_IN_HAND = 5;
    public static final int MAX_RANK = 15;

    /**
     * Constructor for objects of class CountRank.  Sets the counts in the array from a hand. 
     */
    public CountRank(Hand h)
    {
        rankCount = new int[MAX_RANK];
        for(int i =0; i< CARDS_IN_HAND;i++)
        {
            rankCount[h.getCard(i).getRank()]++;
        }
    }

    /**
     * Method determines if hand is a four of a kind. Four cards have to have the same rank.  
     *
     * @return    if the hand has four of a kind or not
     */
    public boolean fourOfAKind()
    {
        for (int countRank : rankCount) 
        {
            if (countRank == 4) 
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method determines if hand has one pair. Two cards have to have the same rank.  
     *
     * @return    if the hand has one pair or not
     */
    public boolean onePair()
    {
        for (int countRank : rankCount) 
        {
            if (countRank == 2) 
            {
                return true;
            }
        }
        return false;        
    }

    /**
     * Method determines if hand has two pairs.  
     *
     * @return    if the hand has two pairs or not
     */
    public boolean twoPair()
    {
        int pairCount = 0;
        for (int countRank : rankCount) 
        {
            if (countRank == 2) 
            {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    /**
     * Method determines if hand has three of a kind. Three cards have to have the same rank.  
     *
     * @return    if the hand has three of a kind or not
     */
    public boolean threeOfAKind()
    {
        for (int countRank : rankCount) 
        {
            if (countRank == 3) 
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method determines if hand has one pair. Two cards have to have the same rank.  
     *
     * @param  min,max  minimum and maximum indexes   
     * @return    if the hand is straight or not
     */
    public boolean straight(int min, int max)
    {
        boolean result = false;
        if((max-min)==4 )
        {
            for(int i = min; i<=max; i++)
            {
                if(rankCount[i]!=1)
                {
                    return result;
                }
            }
            return true;
        }
        else if(hasAce())
        {
            if((max==Card.ACE)&&(min==2))
            {
                for(int i = min;i<=5;i++)
                {
                    rankCount[i] = 1;
                    return true;
                }                
            }
        }
        return result;
    }

    /**
     * Method determines if hand has full house. Hand has to have three of a kind and a pair.  
     *
     * @return    if the hand has full house or not
     */
    public boolean fullHouse()
    {
        int pairCount = 0;
        int threeOfAKindCount = 0;
        for (int countRank : rankCount) 
        {
            if (countRank == 2) 
            {
                pairCount++;
            }
            if (countRank == 3) 
            {
                threeOfAKindCount++;
            }
        }

        if((threeOfAKindCount == 1) && (pairCount == 1))
        {
            return true;
        }
        else 
        {
            return false;
        }  
    }

    /**
     * Method gets minimum rank 
     *
     * @return    minimum rank index
     */
    public int getMinRank()
    {
        for(int i = 0;i<MAX_RANK;i++)
        {
            if(rankCount[i] >=1)
            {
                return i;
            }
        }        
        return -1;
    }

    /**
     * Method gets maximum rank 
     *
     * @return    maximum rank index
     */
    public int getMaxRank()
    {
        for(int i = 14;i>=2;i--)
        {
            if(rankCount[i] >=1)
            {
                return i;
            }
        }        
        return -1;
    }

    /**
     * Method checks to see if rank ACE is in hand.
     *
     * @return    if hand has an ACE or not
     */
    private boolean hasAce()
    {
        if(rankCount[Card.ACE]>=1)
        {
            return true;
        }        
        return false;
    }

    /**
     * Returns rankCount array, nicely formatted.
     *
     * @return    nicely formatted String
     */
    public String toString()
    {       
        StringBuilder stringBuilder = new StringBuilder();

        for (int strInt : rankCount) 
        {            
            stringBuilder.append(Integer.toString(strInt));
            stringBuilder.append(" ");       
        }
        return stringBuilder.toString();
    }
}

