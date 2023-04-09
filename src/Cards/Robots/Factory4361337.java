package Cards.Robots;

import Cards.Base;
import Cards.Player;
import Cards.Signal;
import Cards.Signals;

import java.util.ArrayList;


public class Factory4361337 extends Base {
    // Factory 436-1337 - breakpoint 25 - VPs: 2 2 1 - When this base scores, the winner gains 1 VP for every 5 power that player has here. FAQ
    public Factory4361337(){

    }

    @Override
    public <T extends Signal> void handleSignal(Signals signal, T card) {
        switch (signal){
            case SCORE -> {
                // Find Best Score
                int maxPlayerPower = -1;
                // Players who got the best score...
                ArrayList<Player> maxPlayers = new ArrayList<>();

                for(Player p: this.playedCards.keySet()){
                    int playerPower = this.totalPower(p);
                    if(playerPower > maxPlayerPower){
                        maxPlayerPower = playerPower;
                        maxPlayers.clear();
                        maxPlayers.add(p);
                    }
                    if(playerPower == maxPlayerPower){
                        maxPlayers.add(p);
                    }
                }

                // Every player with the best score gets some extra VP...
                for(Player p: maxPlayers){
                    p.setTotalVP(p.getTotalVP() + (maxPlayerPower/5));
                }
            }
        }
    }
}
