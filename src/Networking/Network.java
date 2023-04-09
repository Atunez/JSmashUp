package Networking;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
    // This a very basic support for multiplayer, so two people can play across two computers.
    // This uses an old library for multiplayer, but it is the simplist one I could find. So I work with it.
    static public final int port = 54321; // I really hope you don't use this port

    static public void register(EndPoint endPoint){
        Kryo kyro = endPoint.getKryo();
        kyro.register(NumberInput.class);
        kyro.register(StringInput.class);
    }

    static public class NumberInput {
        public int numberinput;
        public String intent; // This is actually an ENUM, im lazy. Please don't Judge.
    }

    static public class StringInput {
        public String stringinput;
        public String intent; // This is actually an ENUM, im lazy. Please don't Judge.
    }
}
