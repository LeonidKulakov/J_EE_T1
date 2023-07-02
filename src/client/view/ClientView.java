package client.view;

import client.service.ButtonGetQuote;

import javax.swing.*;
import java.awt.*;
/**
 * Класс пользовательского интерфейса
 */
public class ClientView extends JFrame {

    public static void main(String[] args) {
        ClientView view = new ClientView();
        view.setVisible(true);
    }
    private JButton buttonGetQuote;

    public ClientView() {
        super("Task 1");

        this.setBounds(400, 100, 400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 4, 30));
        container.add(new JLabel("Нажми кнопку для получения цитаты"));
        buttonGetQuote = new JButton("Жмяк");
        buttonGetQuote.addActionListener(new ButtonGetQuote());
        container.add(buttonGetQuote);
    }
}
