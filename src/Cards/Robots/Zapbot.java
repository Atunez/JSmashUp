package Cards.Robots;

import Cards.Events.OnPlay;
import Cards.IOInteractions;
import Cards.Player;

public class Zapbot extends RobotMinions implements OnPlay {
    // Zapbot - power 2 - You may play an extra minion of power 2 or less.

    public Zapbot(Player owner) {
        super(owner, false, 2);
    }

    @Override
    public void OnPlay() {
        // Not sure how to do this....
        System.out.println("Play Extra Minion of power 2 or less (Y/N)?");
        boolean takeCard = IOInteractions.getYesOrNo();
    }
}
