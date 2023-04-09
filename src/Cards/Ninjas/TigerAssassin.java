package Cards.Ninjas;

import Cards.Minion;
import Cards.Player;

public class TigerAssassin extends Minion {
    // power 4 - You may destroy a minion of power 3 or less on this base.
    public TigerAssassin(Player owner) {
        super(owner, 4);
    }
}
