package Cards.Robots;

import Cards.Card;
import Cards.Signals;
import Cards.Field;
import Cards.Player;

public class MicrobotArchive extends RobotMinions {
    public MicrobotArchive(Player owner) {
        super(owner, true);
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
