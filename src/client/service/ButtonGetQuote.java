package client.service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
/**
 * Класс Обработки активности кнопки
 * */
public class ButtonGetQuote implements ActionListener {
    private final int PORT = 8889;
    private final String IP = "127.0.0.1";

    public ButtonGetQuote() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Socket client = new Socket(IP, PORT);
            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            JOptionPane.showMessageDialog(null, inputStream.readObject());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
}
