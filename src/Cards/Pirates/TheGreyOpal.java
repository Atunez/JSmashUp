package Cards.Pirates;

import Cards.Base;

public class TheGreyOpal extends Base {
    // breakpoint 17 - VPs: 3 1 1 - After this base scores, all players other than the winner may move a minion from here to another base instead of the discard pile.
    public TheGreyOpal() {
        super(17, new int[]{3,1,1,0});
    }
}
