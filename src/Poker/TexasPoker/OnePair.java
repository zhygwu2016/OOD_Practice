package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class OnePair extends Pattern{

    private final int pairValue;

    public OnePair(@NotNull String userId, @NotNull List<Card> cards) {
        super(HandValues.One_Pair, userId, cards);
        pairValue = findPairValue(cards);
    }

    private int findPairValue(List<Card> cards) {
        for(int i = 1; i < cards.size(); i++){
            if(cards.get(i - 1).getValue() == cards.get(i).getValue()) {
                return cards.get(i).getValue();
            }
        }

        return -1;
    }

    @Override
    public int compareTo(Object o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(handValues.getValue() == other.handValues.getValue()) {

            final OnePair otherOne = (OnePair) o;

            if(pairValue != otherOne.pairValue) {
                return pairValue - otherOne.pairValue;
            } else {
                for(int i = 4; i >= 0; i--){
                    final Card thisCard = cards.get(i);
                    final Card otherCard = other.getCards().get(i);

                    if(thisCard.getValue() != otherCard.getValue()) {
                        return thisCard.getValue() - otherCard.getValue();
                    }
                }
            }

            return 0;
        } else {
            //If not same pattern then return their pattern value
            return handValues.getValue() - other.handValues.getValue();
        }
    }
}
