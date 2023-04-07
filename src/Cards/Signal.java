package Cards;

public interface Signal {
    void emitSignal(Signals signal);

    // Technically, anything that implements signal can signal the signal...
    // Its just what has to handle it has to be careful...
    default <T extends Signal> void handleSignal(Signals signal, T card){
        return;
    }
}
