package Cards;

import java.util.ArrayList;
import java.util.Map;

public class Base implements Signal {
    // Each Base Is Essentially...
    protected int breakpoint;
    protected int[] scoreVP = {0,0,0};
    protected Map<Player, ArrayList<Card>> playedCards;

    protected int totalPower(Player player){
        if(this.playedCards.get(player) == null){
            return 0;
        }

        return 1;
    }

    protected boolean reachedBreak(){
        return true;
    }
    public boolean checkBaseBreak(){
        if(!reachedBreak()){
            return false;
        }
        // assign VP...

        return true;
    }

    public Map<Player, ArrayList<Card>> getPlayedCards() {
        return this.playedCards;
    }

    public void setPlayedCards(Map<Player, ArrayList<Card>> playedCards) {
        this.playedCards = playedCards;
    }

    @Override
    public void emitSignal(Signals signal) {

    }

    @Override
    public <T extends Signal> void handleSignal(Signals signal, T card) {
        Signal.super.handleSignal(signal, card);
    }
}
