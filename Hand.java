import java.util.ArrayList;
import java.util.*;
import java.lang.String;
/**
 * Represents a hand of 5 cards.
 *
 * @author (Sophia Nguyen)
 * @version (4/25/19)
 */

public class Hand
{
    public static final int NO_PAIR = 0;
    public static final int ONE_PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH = 8;
    public static final int ROYAL_FLUSH = 9;

    private ArrayList<Card> cards;

    /**
     * Constructor for objects of class Hand
     */

    public Hand(Card first, Card second, Card third, Card fourth, Card fifth)
    {
        cards=new ArrayList<>();
        cards.add(first);
        cards.add(second);
        cards.add(third);
        cards.add(fourth);
        cards.add(fifth);
        validateHand();
    }

    /**
     * Method returns the card at index i from a hand but does not remove the card from hand.
     *
     * @param  i  index 
     * @return    the card at the index
     */
    public Card getCard(int i)
    {
        Card card = cards.get(i);
        return card;
    }

    /**
     * Method determines the category of the hand
     *
     * @return    the category of hand
     */
    public int category()
    {
        int category = NO_PAIR; 

        if (royalFlush())
            category = ROYAL_FLUSH;
        else if (fullHouse())
            category = FULL_HOUSE;
        else if (straightFlush())
            category = STRAIGHT_FLUSH;
        else if (fourOfAKind())
            category = FOUR_OF_A_KIND;
        else if (twoPair())
            category = TWO_PAIR;
        else if (threeOfAKind())
            category = THREE_OF_A_KIND;
        else if (flush())
            category = FLUSH;        
        else if (straight())
            category = STRAIGHT;
        else if (onePair())
            category = ONE_PAIR;
        return category;
    }

    /**
     * Method determines if hand has no pairs.
     *
     * @return    if the hand has no pairs or not
     */
    private boolean noPair()
    {
        for (int i = 0; i < cards.size(); i++) 
        {
            for (int j = i+1; j < cards.size(); j++) 
            {
                int rank1 = cards.get(i).getRank();
                int rankNext2 =cards.get(j).getRank();
                int suit1 = cards.get(i).getSuit();
                int suitNext2 = cards.get(j).getSuit();
                if ((rank1!=rankNext2) && (suit1!=suitNext2))
                {
                    return true;                                                            
                }
            }
        }
        return false;
    }

    /**
     * Method determines if hand is a flush.  All cards have to have the same suit.
     *
     * @return    if the hand is flush or not
     */
    private boolean flush() 
    {
        for(int i = 0; i< cards.size()-1; i++)
        {
            int value = cards.get(i).getSuit();
            int nextValue = cards.get(i+1).getSuit();
            if(value != nextValue)
            {
                return false;
            }            
        }
        return true;
    }

    /**
     * Method determines if hand is a royal flush.  This is the best possible hand. All cards have to have the same suit and contain a 10,Jack,Queen,King,and Ace.
     *
     * @return     if the hand is royal flush flush or not
     */
    public boolean royalFlush()
    {
        if(!flush())
        {
            return false;
        }
        for(int i = Card.TEN;i <= Card.ACE; i++)
        {
            if(!findRank(i))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method calls upon threeOfAKind method in countRank.
     *
     * @return    if the hand has three of a kind or not
     */
    public boolean threeOfAKind()
    {
        CountRank cr = new CountRank(this); 
        return cr.threeOfAKind();
    }

    /**
     * Method calls upon fullHouse method in countRank.
     *
     * @return    if the hand is full house or not
     */
    private boolean fullHouse() 
    {
        CountRank cr = new CountRank(this); 
        return cr.fullHouse();
    }

    /**
     * Method calls upon twoPair method in countRank.
     *
     * @return    if the hand has two pair or not
     */
    public boolean twoPair()
    {
        CountRank cr = new CountRank(this); 
        return cr.twoPair();
    }

    /**
     * Method calls upon fourOfAKind method in countRank.
     *
     * @return    if the hand has four of a kind or not
     */
    public boolean fourOfAKind()
    {
        CountRank cr = new CountRank(this); 
        return cr.fourOfAKind();
    }

    /**
     * Method calls upon straight method in countRank.
     *
     * @return    if the hand is straight or not
     */
    public boolean straight()
    {
        CountRank cr = new CountRank(this);
        return cr.straight(cr.getMinRank(),cr.getMaxRank());
    }

    /**
     * Method calls upon flush and straight method. All cards have to have the same suit and consecutive rank.
     *
     * @return    if the hand is straight flush or not
     */
    public boolean straightFlush()
    {
        return flush() && straight();
    }

    /**
     * Method calls upon onePair method in countRank.
     *
     * @return    if the hand has one pair or not
     */
    public boolean onePair()
    {
        CountRank cr = new CountRank(this); 
        return cr.onePair();
    }

    /**
     * Method validates the hand for duplicates.
     *
     * @return    if hand is valid or not
     */
    public boolean validateHand()
    {       
        boolean result=true;
        for (int i = 0; i < cards.size(); i++) 
        {
            for (int j = i+1; j < cards.size(); j++) 
            {
                int rank = cards.get(i).getRank();
                int rankNext =cards.get(j).getRank();
                int suit = cards.get(i).getSuit();
                int suitNext = cards.get(j).getSuit();
                if ((rank==rankNext) && suit==suitNext)
                {
                    System.out.print("The card is duplicated");
                    System.err.print("The card is duplicated");
                    result = false;
                    break;

                }
            }
        }
        return result;
    }


    /**
     * Method finds rank of card at i in hand.
     *
     * @param  rank  rank of Card to compare to 
     * @return    if hand has that rank or not  
     */
    private boolean findRank(int rank)
    {
        for(int i = 0; i < cards.size(); i++)
        {
            if(cards.get(i).getRank() == rank)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns cards, nicely formatted.
     *
     * @return    nicely formatted String
     */
    public String toString()
    {
        return cards.toString();
    }
}

