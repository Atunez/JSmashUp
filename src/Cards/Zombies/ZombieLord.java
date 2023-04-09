package Cards.Zombies;

import Cards.Minion;
import Cards.Player;

public class ZombieLord extends Minion {
    // power 5 - You may play an extra minion of power 2 or less from your discard pile on each base where you have no minions.
    public ZombieLord(Player owner) {
        super(owner, 5);
    }
}
