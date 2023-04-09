package Cards.Pirates;

import Cards.Minion;
import Cards.Player;

public class PirateKing extends Minion {
    // power 5 - Special: Before a base scores, you may move this minion there.
    public PirateKing(Player owner) {
        super(owner, 5);
    }
}
