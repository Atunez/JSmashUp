package Cards.Ninjas;

import Cards.Action;
import Cards.Player;

public class SmokeBomb extends Action {
// Play on one of your minions. Ongoing: This minion is not affected by other players’ actions. Destroy this card at the start of your turn.
    public SmokeBomb(Player owner) {
        super(owner);
    }
}
