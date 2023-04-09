package Cards.Robots;

import Cards.Action;
import Cards.Player;
import Cards.Signal;
import Cards.Signals;

public class TechCenter extends Action {

    // Tech Center - Choose a base. Draw one card for each of your minions there.
    public TechCenter(Player owner) {
        super(owner);
    }

    @Override
    public <T extends Signal> void handleSignal(Signals signal, T card) {
        super.handleSignal(signal, card);
    }
}
