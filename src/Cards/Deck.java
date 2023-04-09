package Cards;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Deck {
    // Minion and Action Cards
    private ArrayList<Card> MACards;

    private Titan titan;

    private String deckSet;

    public Deck(String deckName, Player owner){
        generateDeckFromDefinition(deckName, owner);
    }


    protected static String getFileInformation(String deckName){
        String output = "{}";
        String baseDirectory = System.getProperty("user.dir");
        String toDeckDefinition = "\\src\\DeckDefinitions\\" + deckName + ".json";
        try {
            output = new String(Files.readAllBytes(Paths.get(baseDirectory + toDeckDefinition)));
        }catch(Exception e){
            e.printStackTrace();
        }
        return output;
    }
    private void generateDeckFromDefinition(String deckName, Player owner){
        String fileJSON = getFileInformation(deckName);
        Map<String, JsonElement> deckDefintion = new JsonParser().parse(fileJSON).getAsJsonObject().asMap();

        ArrayList<Card> cardsInDeck = new ArrayList<>();

        for(String entry: deckDefintion.keySet()){
            if(entry.equalsIgnoreCase("Set")){
                this.deckSet = deckDefintion.get(entry).getAsString();
            } else if (entry.equalsIgnoreCase("Titan")) {
                String cardName = deckDefintion.get(entry).getAsString();
                try {
                    this.titan = (Titan) Class.forName("Cards." + deckName + "." + cardName.replaceAll("[^0-9a-zA-Z]*", "")).getDeclaredConstructors()[0].newInstance(owner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else{
                Map<String, JsonElement> classSpecifics = deckDefintion.get(entry).getAsJsonObject().asMap();
                for(String cardName: classSpecifics.keySet()){
                    int count = classSpecifics.get(cardName).getAsInt();
                    String className = cardName.replaceAll("[^0-9a-zA-Z]*", "");
                    try {
                        Constructor<Card> c = (Constructor<Card>) Class.forName("Cards." + deckName + "." + className).getDeclaredConstructors()[0];
                        for(int i = 0; i < count; i++){
                            cardsInDeck.add(c.newInstance(owner));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if(cardsInDeck.size() != 20){
            System.out.println("Error! Deck Size isn't 20, its: " + cardsInDeck.size());
            System.out.println(cardsInDeck);
        }

        this.MACards = cardsInDeck;
    }

    public ArrayList<Card> getMACards(){
        return this.MACards;
    }

    public Titan getTitan() { return this.titan; }

    public String getDeckSet(){
        return this.deckSet;
    }
}
