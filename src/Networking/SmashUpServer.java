package Networking;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;


public class SmashUpServer {
    Server server;
    HashSet<String> usersConnected;
    public int numberOfPlayers;
    static Scanner kb = new Scanner(System.in);

    public SmashUpServer(int numberOfPlayers, String nickname) throws IOException {
        this.numberOfPlayers = numberOfPlayers;
        this.usersConnected = new HashSet<>();
        this.usersConnected.add(nickname);
        this.server = new Server();

        Network.register(this.server);

        server.addListener(new Listener(){
            public void received(Connection c, Object obj){
                if(obj instanceof Network.StringInput){
                    switch (((Network.StringInput) obj).intent){
                        case "NICK":
                            String name = ((Network.StringInput) obj).stringinput;
                            if(usersConnected.size() == numberOfPlayers){
                                Network.StringInput rj = new Network.StringInput();
                                rj.intent = "REJECT";
                                rj.stringinput = "Server is Full";
                                c.sendTCP(rj);
                                break;
                            }
                            if(usersConnected.contains(name)){
                                Network.StringInput rj = new Network.StringInput();
                                rj.intent = "REJOIN";
                                rj.stringinput = "Server has this name!";
                                c.sendTCP(rj);
                                break;
                            }
                            usersConnected.add(((Network.StringInput) obj).stringinput);
                            System.out.println("One User Connected....");
                            System.out.println(((Network.StringInput) obj).stringinput);
                            break;
                    }
                }
            }

            public void disconnected (Connection c) {
                Network.StringInput si = new Network.StringInput();
                si.intent = "DC";
                si.stringinput = "Someone Discontented, Disconnecting lobby :(";
                server.sendToAllTCP(si);
                System.exit(1);
            }
        });

        this.server.bind(Network.port);
        this.server.start();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("How many players will join? (Include yourself) Give your nickname afterwards");
        SmashUpServer server = new SmashUpServer(kb.nextInt(), kb.nextLine());

    }
}

