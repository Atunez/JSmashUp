package Cards.Robots;

import Cards.Events.OnPlay;
import Cards.IOInteractions;
import Cards.Player;

public class Hoverbot extends RobotMinions implements OnPlay {
    // Hoverbot - power 3 - Reveal the top card of your deck. If it is a minion, you may play it as an extra minion. Otherwise, return it to the top of your deck.
    public Hoverbot(Player owner) {
        super(owner, false, 3);
    }

    @Override
    public void OnPlay() {
        // Reveal top card...
        System.out.println("For Player: " + this.getOwner() + " Revealing Top Card:");
        System.out.println(this.getOwner().getTopXCard(1).get(0));
        System.out.println("Take Card (Y) or Leave it (N)?");
        boolean takeCard = IOInteractions.getYesOrNo();

        if(takeCard){
            this.getOwner().drawTopXCard(1);
        }
    }
}
