package ui;

//import java.awt.Color;

import model.Book;
import model.Library;
import model.Publication;
import model.Video;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;


public class LibraryPanel {
    public LibraryPanel(Library library) {
        JFrame frame = new JFrame("Publication Menu");
        frame.setSize(500, 400);
        JPanel jp = new JPanel();
        JButton btn1 = new JButton("Book");
        JButton btn2 = new JButton("Video");
        JButton btn3 = new JButton("Return");
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("smallpub.png"));
        JLabel label = new JLabel(imageIcon);
        btn3.setBackground(Color.lightGray);
        jp.add(btn1);
        jp.add(btn2);
        jp.add(btn3);
        jp.add(label);
        Dimension preferredSize = new Dimension(160, 60);
        btn1.setPreferredSize(preferredSize);
        btn2.setPreferredSize(preferredSize);
        btn3.setPreferredSize(preferredSize);
        frame.add(jp);
        frame.setBounds(300, 200, 600, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Publication book = new Book(null,0,0);
                new MenuJPanel(book,library);
                frame.setVisible(false);


            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Publication video = new Video(null,0,0);
                new MenuJPanel(video,library);
                frame.setVisible(false);

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerOrPub();
                frame.setVisible(false);
            }
        });


    }







}
