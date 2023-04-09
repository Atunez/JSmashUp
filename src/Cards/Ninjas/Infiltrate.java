package Cards.Ninjas;

import Cards.Action;
import Cards.Player;

public class Infiltrate extends Action {
    // Play on a base. Destroy another action that has been played here. Ongoing: You may ignore this base’s ability. Destroy this card at the start of your turn.

    public Infiltrate(Player owner) {
        super(owner);
    }
}
