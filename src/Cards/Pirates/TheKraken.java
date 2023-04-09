package Cards.Pirates;

import Cards.Player;
import Cards.Titan;

public class TheKraken extends Titan {
    //Special: After a base scores where you had a minion while this card is not in play, you may say “Release the Kraken!” to play this titan on the base that replaces it.
    // Talent: Move this titan to another base. Other players’ minions there get -1 power until the end of the turn.
    // Special: After this base scores, move one of your minions from here to another base instead of the discard pile.
    public TheKraken(Player owner) {
        super(owner);
    }
}
