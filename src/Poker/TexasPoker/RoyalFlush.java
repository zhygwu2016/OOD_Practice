package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import Class1.Poker.Suit;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class RoyalFlush extends Pattern{

    private final Suit suit;

    private final int largestCardValue;

    public RoyalFlush(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(HandValues.Royal_Flush, userId, cards);
        suit = cards.get(0).getSuit();
        largestCardValue = cards.get(cards.size() -1).getValue();
    }

    @Override
    public int compareTo(Object o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(handValues.getValue() == other.getHandValues().getValue()) {
            final RoyalFlush otherFlush = (RoyalFlush) o;

            //If both are Royal Flush, then compare their largest card number
            if(largestCardValue > otherFlush.largestCardValue) {
                return 1;
            }

            //If their larget card number is same, compare their Suit value
            return suit.getValue() > otherFlush.suit.getValue() ? 1 : -1;
        } else {
            //If not same pattern then return their pattern value
            return 1;
        }
    }

    public Suit getSuit(){
        return suit;
    }

    public int getLargestCardValue(){
        return largestCardValue;
    }
}
