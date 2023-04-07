package Cards;

import java.util.ArrayList;

public class Field {
    private ArrayList<Base> inPlayBases;

    private static Field me;
    private Field(){
        this.inPlayBases = new ArrayList<>();
    }
    public static Field getField(){
        if(me == null){
            me = new Field();
        }
        return me;
    }

    public ArrayList<Base> getInPlayBases() {
        return inPlayBases;
    }

    public ArrayList<Card> getAllCardsInPlay() {
        ArrayList<Card> out = new ArrayList<>();
        for(Base b: this.inPlayBases){
            for(Player p: b.playedCards.keySet()){
                out.addAll(b.playedCards.get(p));
            }
        }
        return out;
    }

//    public boolean isCardInPlay(Card card){
//        for(Card c: getAllCardsInPlay()){
//            if(c == card || c instanceof card){
//                return true;
//            }
//        }
//        return false;
//    }

    public Base findBaseWithCard(Card card) {
        for(Base b: this.inPlayBases){
            for(Player p: b.playedCards.keySet()){
                if(b.playedCards.get(p).stream().anyMatch(c1 -> c1 == card)){
                    return b;
                }
            }
        }
        return null;
    }

    public void setInPlayBases(ArrayList<Base> inPlayBases) {
        this.inPlayBases = inPlayBases;
    }
}
