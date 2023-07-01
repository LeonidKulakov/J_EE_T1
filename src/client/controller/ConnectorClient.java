package client.controller;

import java.io.IOException;
import java.net.Socket;

/**
 * Класс обеспечивает соединение клиента с сервером
 * Не нравится что создание сакета происходит в конструкторе
 */
public class ConnectorClient {
    private Socket client;

    public ConnectorClient() {
        setConnection();
    }

    private void setConnection() {
        try {
            client = new Socket("127.0.0.1", 8889);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getClient() {
        return client;
    }
}
