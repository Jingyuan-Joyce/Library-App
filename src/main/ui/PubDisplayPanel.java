package ui;

import model.Book;
import model.Library;
import model.Publication;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class PubDisplayPanel {

    public PubDisplayPanel(Library library) {
        JFrame frame = new JFrame("Publications In Library");
        JPanel jp = new JPanel();
        Map<Integer, Publication> map = (Map<Integer, Publication>) library.getPublicationMap();
        for (Map.Entry<Integer, Publication> entry : map.entrySet()) {
            String data = entry.getValue().toString();
            JLabel label = new JLabel(data);
            JLabel label1 = new JLabel();
            jp.add(label);
            jp.add(label1);
        }
        JButton confirmButton = new JButton("Confirm");
        jp.add(confirmButton, BorderLayout.SOUTH);
        JButton returnButton = new JButton("Return");
        jp.add(returnButton,BorderLayout.SOUTH);

        frame.add(jp);
        frame.setBounds(500, 200, 400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new WelcomePage();
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MenuJPanel(null,library);

            }
        });

    }

}
