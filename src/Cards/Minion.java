package Cards;

import java.util.ArrayList;

public class Minion extends Card {
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCounters() {
        return counters;
    }

    public void setCounters(int counters) {
        this.counters = counters;
    }

    private int power;
    private int counters;

    private ArrayList<Card> actionsOnMinion;

    public Minion(Player owner, int power) {
        super(owner);
        this.power = power;
        this.actionsOnMinion = new ArrayList<>();
    }

    public int getTotalPower(){
        return this.power + this.counters;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "power=" + getTotalPower() +
                ", name=" + this.getClass().getName() +
                '}';
    }

    public void addActionToMinion(Card c){
        this.actionsOnMinion.add(c);
    }
}
