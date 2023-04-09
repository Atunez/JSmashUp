package Cards.Robots;

import Cards.Player;

public class MicrobotGuard extends RobotMinions {

    // Microbot Guard - power 1 - Destroy a minion on this base with power less than the number of minions you have here.
    public MicrobotGuard(Player owner) {
        super(owner, true, 1);
    }
}
