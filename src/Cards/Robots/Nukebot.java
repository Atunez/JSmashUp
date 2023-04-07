package Cards.Robots;

import Cards.Base;
import Cards.Card;
import Cards.Signals;
import Cards.Field;
import Cards.Player;

import java.util.ArrayList;
import java.util.Map;

// This Class Specifies the information for Nukebot
// It is a minion, that has something OnDestroy...
public class Nukebot extends RobotMinions {
    public Nukebot(Player owner) {
        super(owner, false);
    }

    public void handleSignal(Signals signal, Card card){
        switch (signal){
            case DESTROYED -> {
                Base base = Field.getField().findBaseWithCard(card);
                if(this == card){
                    Map<Player, ArrayList<Card>> cardsOnBase = base.getPlayedCards();
                    for(Player p: cardsOnBase.keySet()){
                        if(p != this.getOwner()){
                            cardsOnBase.replace(p, null);
                        }
                    }
                    base.setPlayedCards(cardsOnBase);
                }
            }
        }
    }
}
