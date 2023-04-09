package Cards.Ninjas;

import Cards.Action;
import Cards.Player;

public class Disguise extends Action {
    // Choose one or two of your minions on one base. Play an equal number of extra minions there, and return the chosen minions to your hand.
    public Disguise(Player owner) {
        super(owner);
    }
}
