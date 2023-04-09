package Cards.Robots;

import Cards.Base;
import Cards.Events.OnGoing;
import Cards.Events.OnPlay;
import Cards.Field;
import Cards.Player;

public class MicrobotAlpha extends RobotMinions implements OnGoing, OnPlay {

    // Microbot Alpha - power 1 - Ongoing: Gains +1 power for each of your other Microbots. All of your minions are considered Microbots.
    public MicrobotAlpha(Player owner) {
        super(owner, true, 1);
    }

    @Override
    public void OnGoing() {
        OnPlay();
    }

    @Override
    public void OnPlay() {
        int totalCards = 0;
        for(Base b: Field.getField().getInPlayBases()){
            totalCards += b.getPlayedCards().get(this.getOwner()).size();
        }
        this.setCounters(this.getCounters() + totalCards);
    }
}
