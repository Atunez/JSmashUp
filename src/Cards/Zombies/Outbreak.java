package Cards.Zombies;

import Cards.Action;
import Cards.Player;

public class Outbreak extends Action {
    // Play an extra minion on a base where you have no minions.
    public Outbreak(Player owner) {
        super(owner);
    }
}
