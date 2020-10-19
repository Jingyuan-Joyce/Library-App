package ui;


import model.BookNotFoundException;
import model.Library;
import model.Publication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

import static java.lang.Integer.parseInt;

public class MenuJPanel {

    public MenuJPanel(Publication p, Library library) {
        JFrame frame = new JFrame("Menu");
        try {
            library.loadable("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(400, 200);
        JPanel jp = new JPanel();
        JButton btn1 = new JButton("addPublication");
        JButton btn2 = new JButton("borrowPublication");
        JButton btn3 = new JButton("searchButton");
        JButton btn6 = new JButton("Display Publication");
        JButton btn4 = new JButton("Return");
        JButton btn5 = new JButton("All Done");
        jp.add(btn1);
        jp.add(btn2);
        jp.add(btn3);
        jp.add(btn6);
        jp.add(btn4);
        jp.add(btn5);
        Dimension preferredSize = new Dimension(160, 60);
        btn1.setPreferredSize(preferredSize);
        btn2.setPreferredSize(preferredSize);
        btn3.setPreferredSize(preferredSize);
        btn4.setBackground(Color.lightGray);
        btn5.setBackground(Color.YELLOW);
        frame.add(jp);
        frame.setBounds(300, 200, 600, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    String input = JOptionPane.showInputDialog(jp, "How many would you add", "NUMBER", 1);
                    int i = Integer.parseInt(input);
                    if (i >= 100) {
                        JOptionPane.showMessageDialog(null, "That is too many you want to add");
                        continue;
                    } else {
                        new InformationJPanel(p, i, library);
                        break;
                    }

                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = JOptionPane.showInputDialog(jp, "enter the borrow number", "Publication Number", 1);
                int borrowNum = Integer.parseInt(b);
                try {
                    Publication p = library.lookForPublication(borrowNum);
                    library.borrowBook(p);
                    library.savable("data.txt");
                    JOptionPane.showMessageDialog(jp, p.getName()
                            + " borrowed", "Info", JOptionPane.PLAIN_MESSAGE);

                } catch (BookNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Not found！", "Error ", 0);
                }


            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = JOptionPane.showInputDialog(jp, "enter the search number", "Publication Number", 1);
                int borrowNum = Integer.parseInt(b);
                try {
                    Publication p = library.lookForPublication(borrowNum);
                    JOptionPane.showMessageDialog(jp, p.getName() + " found", "Info", JOptionPane.PLAIN_MESSAGE);

                } catch (BookNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Not found！", "Error ", 0);

                }
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LibraryPanel(library);
                frame.setVisible(false);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomePage();
                frame.setVisible(false);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PubDisplayPanel(library);
                frame.setVisible(false);
            }
        });

    }
}