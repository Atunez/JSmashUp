package Cards.Zombies;

import Cards.Minion;
import Cards.Player;

public class TenaciousZ extends Minion {
    // power 2 - Special: During your turn you may play this card from your discard pile as an extra minion. You may only use the ability of one Tenacious Z each turn.
    public TenaciousZ(Player owner) {
        super(owner, 2);
    }
}
