package Cards.Ninjas;

import Cards.Action;
import Cards.Player;

public class Poison extends Action {
    // Play on a minion. Destroy any number of actions on it. Ongoing: This minion has -4 power. (Minions have minimum power of 0.)
    public Poison(Player owner) {
        super(owner);
    }
}
