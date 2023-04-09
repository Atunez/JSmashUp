package Cards.Pirates;

import Cards.Minion;
import Cards.Player;

public class Buccaneer extends Minion {
    // power 4 - Special: If this minion would be destroyed, move it to another base instead.
    public Buccaneer(Player owner) {
        super(owner, 4);
    }
}
