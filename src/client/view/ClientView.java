package client.view;

import client.controller.ConnectorClient;
import client.service.ButtonGetQuote;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Класс пользовательского интерфейса
 */
public class ClientView extends JFrame {
    private JButton buttonGetQuote;
    private ConnectorClient connectorClient;
/**
 *
 * Отвратительный try в конструкторе, но иначе не хочет работать,
 * если выношу создание потоков в обработчик события кнопки, он закрывает сокет
 * */
    public ClientView() {
        super("Task 1");

        connectorClient = new ConnectorClient();

        this.setBounds(400, 100, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 4, 30));
        container.add(new JLabel("Нажми кнопку для получения цитаты"));
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(connectorClient.getClient().getOutputStream());
            outputStream.writeObject("Тут имя");
            ObjectInputStream inputStream = new ObjectInputStream(connectorClient.getClient().getInputStream());
            buttonGetQuote = new JButton("Жмяк");
            buttonGetQuote.addActionListener(new ButtonGetQuote(outputStream,inputStream));
            container.add(buttonGetQuote);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
