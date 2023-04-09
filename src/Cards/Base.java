package Cards;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Base implements Signal {
    // Each Base Is Essentially...
    protected int breakpoint;
    // ScoreVP for every possible position
    protected int[] scoreVP = {0,0,0,0};
    protected Map<Player, ArrayList<Card>> playedCards;
    protected Map<Player, ArrayList<Card>> actionsOnBase;

    public Base(int breakpoint, int[] scoreVP){
        this.breakpoint = breakpoint;
        if(scoreVP.length != 4){
            System.out.println("ScoreVP size isn't 4");
            System.exit(1);
        }
        this.scoreVP = scoreVP;

        this.playedCards = new HashMap<>();
        this.actionsOnBase = new HashMap<>();
    }

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
        return;
    }

    public static ArrayList<Base> getAllBasesRequired(ArrayList<String> setsInPlay){
        ArrayList<Base> bases = new ArrayList<>();

        String jsonInFile = Deck.getFileInformation("Bases");
        Map<String, JsonElement> basesAndSets = new JsonParser().parse(jsonInFile).getAsJsonObject().asMap();

        for(String set: basesAndSets.keySet()){
            if (setsInPlay.contains(set)) {
                Map<String, JsonElement> factionAndBases = basesAndSets.get(set).getAsJsonObject().asMap();
                for(String factionName: factionAndBases.keySet()){
                    for(JsonElement baseName: factionAndBases.get(factionName).getAsJsonArray()){
                        String formattedName = baseName.getAsString().replaceAll("[^0-9a-zA-Z]*", "");
                        try{
                            bases.add((Base) Class.forName("Cards." + factionName + "." + formattedName).getConstructors()[0].newInstance());
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return bases;
    }

    @Override
    public String toString() {
        return "Base{" +
                "breakpoint=" + breakpoint +
                ", scoreVP=" + Arrays.toString(scoreVP) +
                ", playedCards=" + playedCards +
                '}';
    }

    public void playCardOnBase(Card c, Player p){
        if(c instanceof Minion){
            if(this.playedCards.get(p) == null){
                this.playedCards.put(p, new ArrayList<>());
            }
            this.playedCards.get(p).add(c);
        }
        if(c instanceof Action){
            if(this.actionsOnBase.get(p) == null){
                this.actionsOnBase.put(p, new ArrayList<>());
            }
            this.actionsOnBase.get(p).add(c);
        }
    }
}
