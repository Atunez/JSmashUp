package Cards.Robots;

import Cards.Events.OnPlay;
import Cards.IOInteractions;
import Cards.Player;

public class Zapbot extends RobotMinions implements OnPlay {

    public Zapbot(Player owner) {
        super(owner, false);
    }

    @Override
    public void OnPlay() {
        // Not sure how to do this....
        System.out.println("Play Extra Minion of power 2 or less (Y/N)?");
        boolean takeCard = IOInteractions.getYesOrNo();
    }
}
