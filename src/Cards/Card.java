package Cards;

public class Card implements Signal {
    private Player owner;

    public Card(Player owner){
        this.owner = owner;
    }
    public Player getOwner() {
        return this.owner;
    }

    public void emitSignal(Signals signal){
        for(Card c: Field.getField().getAllCardsInPlay()){
            c.handleSignal(signal, this);
        }
    }
}
