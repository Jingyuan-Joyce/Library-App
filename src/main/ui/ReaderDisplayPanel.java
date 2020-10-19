package ui;

import model.Library;
import model.Publication;
import model.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ReaderDisplayPanel {
    public ReaderDisplayPanel(Library library) {
        JFrame frame = new JFrame("Readers In Library");
        JPanel jp = new JPanel();
        Map<Integer, Reader> map = (Map<Integer, Reader>) library.getReadersMap();
        for (Map.Entry<Integer, Reader> entry : map.entrySet()) {
            String data = entry.getValue().toString();
            JLabel label = new JLabel(data);
            JLabel label1 = new JLabel();
            jp.add(label);
            jp.add(label1);
        }
        JButton confirmButton = new JButton("Confirm");
        jp.add(confirmButton, BorderLayout.PAGE_END);
        JButton returnButton = new JButton("Return");
        jp.add(returnButton,BorderLayout.PAGE_END);

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
                new ReaderPanel(library);
            }
        });

    }




}
