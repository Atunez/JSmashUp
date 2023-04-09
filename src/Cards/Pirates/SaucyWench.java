package Cards.Pirates;

import Cards.Minion;
import Cards.Player;

public class SaucyWench extends Minion {
    // power 3 - You may destroy a minion of power 2 or less on this base.
    public SaucyWench(Player owner) {
        super(owner, 3);
    }
}
