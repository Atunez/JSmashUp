package Cards.Ninjas;

import Cards.Base;

public class NinjaDojo extends Base {
    // breakpoint 18 - VPs: 2 3 2 - After this base scores, the winner may destroy any one minion.
    public NinjaDojo() {
        super(18, new int[]{2,3,2,0});
    }
}
