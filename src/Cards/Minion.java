package Cards;

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
    public Minion(Player owner) {
        super(owner);
    }
}
