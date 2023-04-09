package Cards.Robots;

import Cards.Minion;
import Cards.Player;

public class RobotMinions extends Minion {
    private boolean isMicroBot;

    public boolean isMicroBot() {
        return isMicroBot;
    }

    public RobotMinions(Player owner, boolean isMicroBot, int power) {
        super(owner, power);
        this.isMicroBot = isMicroBot;
    }

}
