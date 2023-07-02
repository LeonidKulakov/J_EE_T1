package server;

import server.logger.LogStorage;
import server.model.Quote;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ListenerQuote implements Runnable {
    private final Socket socket;

    public ListenerQuote(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                var outputStream = new ObjectOutputStream(socket.getOutputStream());
        ) {
            String quote = Quote.getRandomQuote();
            outputStream.writeObject(quote);
            LogStorage.logInfo(socket.getInetAddress().getHostAddress(), quote);
            socket.close();
            LogStorage.logInfo(socket.getInetAddress().getHostAddress());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}