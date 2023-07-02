package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerQuote {
    private final int PORT = 8889;
    private final int MAX_COUNT = 10;

    public static void main(String[] args) {
        ServerQuote serverQuote = new ServerQuote();
        serverQuote.createConnection();
    }
    private void createConnection(){
        try {
            var listener = new ServerSocket(PORT, MAX_COUNT);
            Socket client;
            int count = 0;
            while (count<=MAX_COUNT){
                count++;
                client = listener.accept();
                ListenerQuote lQ = new ListenerQuote(client);
                Thread thread = new Thread(lQ);
                thread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
