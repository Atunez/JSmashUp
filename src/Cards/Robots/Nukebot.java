package Cards.Robots;

import Cards.Base;
import Cards.Card;
import Cards.Signals;
import Cards.Field;
import Cards.Player;

import java.util.ArrayList;
import java.util.Map;

public class Nukebot extends RobotMinions {
    // Nukebot - power 5 - Ongoing: After this minion is destroyed, destroy each other player’s minions on this base.
    public Nukebot(Player owner) {
        super(owner, false, 5);
    }

    public void handleSignal(Signals signal, Card card){
        switch (signal){
            case DESTROYED -> {
                Base base = Field.getField().findBaseWithCard(card);
                if(this == card){
                    Map<Player, ArrayList<Card>> cardsOnBase = base.getPlayedCards();
                    for(Player p: cardsOnBase.keySet()){
                        if(p != this.getOwner()){
                            // All the other cards need to know that they are being destroyed.
                            // TODO: Consider a Queue for the list of events....
                            cardsOnBase.replace(p, null);
                        }
                    }
                    base.setPlayedCards(cardsOnBase);
                }
            }
        }
    }
}
