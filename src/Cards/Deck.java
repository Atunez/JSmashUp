package Cards;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Deck {
    private ArrayList<Card> nonBaseCards;

    private String deckSet;

    public Deck(String deckName, Player owner){
        generateDeckFromDefinition(deckName, owner);
    }


    private String getFileInformation(String deckName){
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
            }else{
                Map<String, JsonElement> classSpecifics = deckDefintion.get(entry).getAsJsonObject().asMap();
                for(String cardName: classSpecifics.keySet()){
                    int count = classSpecifics.get(cardName).getAsInt();
                    // Need better regex..
                    String className = cardName.replaceAll("^?!([a-zA-Z0-9]*)$", "").replace(" ", "").replace("\'", "");
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

        this.nonBaseCards = cardsInDeck;
    }

    public ArrayList<Card> getNonBaseCards(){
        return this.nonBaseCards;
    }

    public String getDeckSet(){
        return this.deckSet;
    }
}
