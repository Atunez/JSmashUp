package Cards.Robots;

import Cards.Card;
import Cards.Signals;
import Cards.Field;
import Cards.Player;

public class MicrobotArchive extends RobotMinions {

    // Microbot Archive - power 1 - Ongoing: After one of your Microbots (including this one) is destroyed, draw a card.
    public MicrobotArchive(Player owner) {
        super(owner, true, 1);
    }

    public void handleSignal(Signals signal, Card card){
        switch (signal){
            case DESTROYED -> {
                boolean MicrobotAlphaInPlay = Field.getField().getAllCardsInPlay().stream().anyMatch(card1 -> card1 instanceof MicrobotAlpha);
                boolean cardIsMicrobot = (card instanceof RobotMinions && ((RobotMinions) card).isMicroBot());
                if (card.getOwner() == this.getOwner() && card != this && (cardIsMicrobot || MicrobotAlphaInPlay)) {
                    this.getOwner().drawTopXCard(1);
                }
            }
        }
    }
}
