package server;

import server.model.Quote;

import java.io.IOException;
import java.io.ObjectInputStream;
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
                var inputStream = new ObjectInputStream(socket.getInputStream());
        ) {
            //TODO Как то надо корректно закрыть сокет, что бы проверять while(!socket.isClosed()) не знаю куда поставить socket.close();
            while (true) {
                outputStream.writeObject(Quote.getRandomQuote());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}