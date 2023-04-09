package Cards;

public class Action extends Card {
    private ActionTypes actionTypes;

    public Action(Player owner, ActionTypes actionTypes) {
        super(owner);
        this.actionTypes = actionTypes;
    }

    public ActionTypes getActionTypes(){
        return this.actionTypes;
    }

    @Override
    public String toString() {
        return "Action{" +
                ", name=" + this.getClass().getName() +
                '}';
    }
}
