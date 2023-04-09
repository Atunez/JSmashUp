package Cards.Robots;

import Cards.Events.CanDestroy;
import Cards.Player;

public class Warbot extends RobotMinions implements CanDestroy {
    // Warbot - power 4 - Ongoing: This minion cannot be destroyed.

    public Warbot(Player owner) {
        super(owner, false, 4);
    }

    @Override
    public boolean canDestroy() {
        return false;
    }
}
