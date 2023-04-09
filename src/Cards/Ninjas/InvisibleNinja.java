package Cards.Ninjas;

import Cards.Player;
import Cards.Titan;

public class InvisibleNinja extends Titan {
    // Special: On your turn, if this titan was not in play at the start of your turn, you may discard a card to play this titan at a base where you have a minion.
    // Ongoing: Once per turn, after you destroy another player's card or return one of your minions to your hand, you may look at the top two cards of your deck, draw one, and shuffle the other into your deck.
    // Special: At the start of your turn, you may destroy this titan to play an extra minion of power 3 or less.
    public InvisibleNinja(Player owner) {
        super(owner);
    }
}
