package Cards.Robots;

import Cards.Player;

public class MicrobotReclaimer extends RobotMinions {

    // Microbot Reclaimer - power 1 - If this is the first minion you played this turn, you may play an extra minion. Shuffle any number of Microbots from your discard pile into your deck.
    public MicrobotReclaimer(Player owner) {
        super(owner, true, 1);
    }
}
