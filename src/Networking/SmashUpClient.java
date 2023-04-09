package Networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

import java.util.Scanner;

public class SmashUpClient {
    Client client;
    String name;

    static Scanner kb = new Scanner(System.in);

    public SmashUpClient() {
        this.client = new Client();
        client.start();

        Network.register(this.client);

        client.addListener(new Listener.ThreadedListener(new Listener(){
            public void connected(Connection c){
                System.out.println(c);
            }

            public void received(Connection c, Object obj){
                System.out.println("We Got Something....");
                System.out.println(obj);
            }
        }));


        System.out.println("What is the host's IP?");
        String host = kb.nextLine();
        try {
            client.connect(5000, host, Network.port);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("What will be your Nickname?");
        String inp = kb.nextLine();

        Network.StringInput nick = new Network.StringInput();
        nick.stringinput = inp;
        nick.intent = "NICK";
        client.sendTCP(nick);
    }

    public static void main(String[] args){
        Log.set(Log.LEVEL_DEBUG);
        SmashUpClient client = new SmashUpClient();

        while(true){
            System.out.println("Wait Till The Server Starts the Game");
            String inp = kb.nextLine();
        }
    }
}
