package Cards.Robots;

import Cards.Player;

public class MicrobotFixer extends RobotMinions {

    // Microbot Fixer - power 1 - If this is the first minion you played this turn, you may play an extra minion. Ongoing: Each of your Microbots gains +1 power
    public MicrobotFixer(Player owner) {
        super(owner, true, 1);
    }
}
