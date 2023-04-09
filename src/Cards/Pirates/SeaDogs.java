package Cards.Pirates;

import Cards.Action;
import Cards.Player;

public class SeaDogs extends Action {
    // Name a faction. Move all other players’ minions of that faction from one base to another.
    public SeaDogs(Player owner) {
        super(owner);
    }
}
