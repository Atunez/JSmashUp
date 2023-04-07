package Cards.Robots;

import Cards.Base;
import Cards.Events.OnBaseScore;
import Cards.Player;

import java.util.ArrayList;


public class Factory4361337 extends Base implements OnBaseScore {

    @Override
    public void OnBaseScore() {
        // Best Score
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

        for(Player p: maxPlayers){
            p.setTotalVP(p.getTotalVP() + (maxPlayerPower/5));
        }
    }
}
