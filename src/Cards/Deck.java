package Cards;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Deck {
    private ArrayList<Card> nonBaseCards;
    private ArrayList<Card> baseCards;

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

        ArrayList<Card> bases = new ArrayList<>();
        ArrayList<Card> nonbases = new ArrayList<>();

        for(String entry: deckDefintion.keySet()){
            if(entry.equalsIgnoreCase("Bases")){

            }else{
                Map<String, JsonElement> classSpecifics = deckDefintion.get(entry).getAsJsonObject().asMap();
                for(String cardName: classSpecifics.keySet()){
                    int count = classSpecifics.get(cardName).getAsInt();
                    for(int i = 0; i < count; i++){
                        if(classSpecifics.equals("Minions")){

                        }else{

                        }
                    }
                }
            }
        }

        if(nonbases.size() != 20){
            System.out.println("Error! Deck Size isn't 20");
        }

        this.baseCards = bases;
        this.nonBaseCards = nonbases;
    }

    public ArrayList<Card> getBaseCards(){
        return this.baseCards;
    }

    public ArrayList<Card> getNonBaseCards(){
        return this.nonBaseCards;
    }
}
