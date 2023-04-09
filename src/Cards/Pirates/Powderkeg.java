package Cards.Pirates;

import Cards.Action;
import Cards.Player;

public class Powderkeg extends Action {
    // Destroy one of your minions and all minions with equal or less power on the same base.
    public Powderkeg(Player owner) {
        super(owner);
    }
}
