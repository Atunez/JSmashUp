package Cards.Ninjas;

import Cards.Minion;
import Cards.Player;

public class Shinobi extends Minion {
    // power 3 - Special: Before a base scores, you may play this minion there. You can only use one Shinobi’s ability per base.
    public Shinobi(Player owner) {
        super(owner, 3);
    }
}
