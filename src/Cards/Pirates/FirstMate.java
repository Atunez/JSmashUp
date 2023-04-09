package Cards.Pirates;

import Cards.Minion;
import Cards.Player;

public class FirstMate extends Minion {
    // power 2 - Special: After this base is scored, you may move this minion to another base instead of the discard pile.
    public FirstMate(Player owner) {
        super(owner, 2);
    }
}
