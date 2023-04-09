package Cards.Ninjas;

import Cards.Action;
import Cards.Player;

public class Assassination extends Action {
    // Play on a minion. Ongoing: Destroy this minion at the end of the turn.
    public Assassination(Player owner) {
        super(owner);
    }


}
