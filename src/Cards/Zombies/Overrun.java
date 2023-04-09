package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class Overrun extends Action {
    // Play on a base. Ongoing: Other players cannot play minions on this base. Destroy this action at the start of your turn.
    public Overrun(Player owner) {
        super(owner);
    }
}
