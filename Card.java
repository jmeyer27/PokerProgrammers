import java.util.ArrayList;
import java.util.*;
import java.lang.String;
/**
 * Designed to create a new card from a rank and suit.
 *
 * @author (Sophia Nguyen)
 * @version (11/1/2022)
 */

public class Card
{
    private final int rank;
    private final int suit;
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    public static final int ACE = 14;
    public static final int KING = 13;
    public static final int QUEEN = 12;
    public static final int JACK = 11;
    public static final int TEN = 10;
    public static final int NINE = 9;
    public static final int EIGHT = 8;
    public static final int SEVEN = 7;
    public static final int SIX = 6;
    public static final int FIVE = 5;
    public static final int FOUR = 4;
    public static final int THREE = 3;
    public static final int TWO = 2;

    /**
     * Constructor for objects of class Card
     * 
     * @param  newRank  to set rank
     * @param  newSuit  to set suit
     */

    public Card(int newRank, int newSuit)
    {          
        rank = newRank;
        suit = newSuit;

        if(newRank>ACE||newRank<TWO)
        {
            //System.err.println
            //("In Card::ctor() -- newRank not valid:" + newRank);
            // also send to standard output, to see it there too
            System.out.println
            ("In Card::ctor() -- newRank not valid:" + newRank);
            //System.exit(1);     
        }

        else if(newSuit<CLUBS||newSuit>SPADES)
        {
            //System.err.println
            //("In Card::ctor() -- newSuit not valid:" + newSuit);
            // also send to standard output, to see it there too
            System.out.println
            ("In Card::ctor() -- newSuit not valid:" + newSuit);
            //System.exit(1);     
        }
    }

    /**
     * Gets rank of card.
     *
     * @return    rank of card
     */
    public int getRank()
    {
        return rank;
    }

    /**
     * Gets suit of card.
     *
     * @return    suit of card
     */
    public int getSuit()
    {
        return suit;
    }

    /**
     * Returns a suit and rank, nicely formatted.
     *
     * @return    nicely formatted String
     */
    public String toString()
    {
        String out = ""; 

        // put the rank into out
        // always in 2 places, for nice formatting      

        // now add single, special char for suit

        if(rank==JACK)
        {
            out+='J';
        }

        else if(rank==QUEEN)
        {
            out+='Q';
        }

        else if(rank==KING)
        {
            out+='K';
        }

        else if(rank==ACE)
        {
            out+='A';
        }

        else 
        {
            out+=rank;
        }

        if (suit == CLUBS)

            out += '\u2663';    // Unicode char for club

        else if (suit == DIAMONDS)

            out += '\u2662';    // Unicode char for diamond

        else if (suit == HEARTS)

            out += '\u2661';    // Unicode char for heart

        else if (suit == SPADES)

            out += '\u2660';   // Unicode char for spade 
        return out;
    }
}   

