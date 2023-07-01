package client.service;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ButtonGetQuote implements ActionListener {

    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;

    public ButtonGetQuote(ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            JOptionPane.showMessageDialog(null, inputStream.readObject());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    }
}
