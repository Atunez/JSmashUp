package Cards.Robots;

import Cards.Events.CanDestroy;
import Cards.Player;

public class Warbot extends RobotMinions implements CanDestroy {

    public Warbot(Player owner) {
        super(owner, false);
    }

    @Override
    public boolean canDestroy() {
        return false;
    }
}
