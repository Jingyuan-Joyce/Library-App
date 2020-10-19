package ui;

import model.BookNotFoundException;
import model.Library;
import model.Publication;
import model.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReaderPanel {

    public ReaderPanel(Library library) {
        JFrame frame = new JFrame("Reader Menu");
        frame.setSize(400, 200);
        JPanel jp = new JPanel();    //创建JPanel对象
        JButton btn1 = new JButton("add reader");
        JButton btn2 = new JButton("remove reader");
        JButton btn3 = new JButton("search reader");
        JButton btn6 = new JButton("display reader");
        JButton btn4 = new JButton("Return");
        JButton btn5 = new JButton("All Done");
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("smallreader.png"));
        JLabel label = new JLabel(imageIcon);
        jp.add(btn1);
        jp.add(btn2);
        Dimension preferredSize = new Dimension(160, 60);
        btn1.setPreferredSize(preferredSize);
        btn2.setPreferredSize(preferredSize);
        btn3.setPreferredSize(preferredSize);
        jp.add(btn3);
        jp.add(btn6);
        btn4.setBackground(Color.lightGray);
        jp.add(btn4);
        jp.add(btn5);
        jp.add(label);
        btn5.setBackground(Color.YELLOW);


        frame.add(jp);
        frame.setBounds(300, 200, 600, 400);
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
                        new ReaderInformationPanel(i, library);
                        break;
                    }
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = JOptionPane.showInputDialog(jp, "enter the remove number", "Reader Number", 1);
                int borrowNum = Integer.parseInt(b);
                Reader r = library.removeCustomer(borrowNum);
                if (r != null) {
                    library.savable("data.txt");
                    JOptionPane.showMessageDialog(jp, r.getName() + " Removed", "Info", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Not found！", "Error ", 0);
                }


            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = JOptionPane.showInputDialog(jp, "enter the search number", "Reader Number", 1);
                int borrowNum = Integer.parseInt(b);
                Reader reader = library.lookForReader(borrowNum);
                if (reader != null) {
                    JOptionPane.showMessageDialog(jp, reader.getName() + " found", "Info", JOptionPane.PLAIN_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Not found！", "Error ", 0);

                }
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerOrPub();
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
                new ReaderDisplayPanel(library);
                frame.setVisible(false);

            }
        });

    }


}
