package Cards;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class IOInteractions {
    private static Scanner kb = new Scanner(System.in);

    public static boolean getYesOrNo(){
        Scanner kb = new Scanner(System.in);
        String inp = "";
        while(!(inp.equalsIgnoreCase("Y") || inp.equalsIgnoreCase("N"))){
            inp = kb.next();
        }
        return inp.equalsIgnoreCase("Y");
    }

    public static int getNumInRange(int minimum, int maximum){
        System.out.println("Enter Number Between " + minimum + " and " + maximum);
        while (true){
            String inp = kb.next();
            try{
                int num = Integer.parseInt(inp);
                if(num >= minimum && maximum >= num){
                    return num;
                }
            }catch (Exception e){
                // Non Number Entered...
                System.out.println("Please Enter a number in the range of: " + minimum + " and " + maximum);
            }
        }
    }

    private static ArrayList<String> getAllDecks(){
        String baseDirectory = System.getProperty("user.dir");
        String toDeckDefinition = "\\src\\DeckDefinitions";
        File folder = new File(baseDirectory + toDeckDefinition);
        File[] filesInFolder = folder.listFiles();

        ArrayList<String> allFiles = new ArrayList<>();
        for(int i = 0; i < filesInFolder.length; i++){
            allFiles.add(filesInFolder[i].getName().replace(".json",""));
        }

        return allFiles;
    }

    public static String getDeckFromIO(ArrayList<String> pickedDecks){
        ArrayList<String> avaliableDecks = getAllDecks();
        for(String s: pickedDecks){
            avaliableDecks.remove(s);
        }
        Scanner kb = new Scanner(System.in);
        while(true){
            System.out.println("Pick a deck from the following decks:");
            System.out.println(avaliableDecks);
            String inp = kb.next();
            if(avaliableDecks.stream().anyMatch(l -> l.equalsIgnoreCase(inp))){
                return avaliableDecks.stream().filter(l -> l.equalsIgnoreCase(inp)).toList().get(0);
            }else{
                System.out.println("Deck Not available, name has to match.");
            }
        }

    }
}
