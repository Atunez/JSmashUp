package Cards.Ninjas;

import Cards.Minion;
import Cards.Player;

public class NinjaAcolyte extends Minion {
    // power 2 - Special: On your turn, if you have not yet played a minion, you may return this minion to your hand and play an extra minion on this base.
    public NinjaAcolyte(Player owner) {
        super(owner, 2);
    }
}
