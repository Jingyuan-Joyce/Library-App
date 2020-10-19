package ui;

import model.Library;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CustomerOrPub {
    private Library library = new Library();

    public CustomerOrPub() {
        try {
            library.loadable("data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Library");
        JPanel jp = new JPanel();
        JLabel label1 = new JLabel("Category：");
        JComboBox cmb = new JComboBox();
        cmb.addItem("--Select--");
        cmb.addItem("Publication");
        cmb.addItem("Reader");
        jp.add(label1);
        jp.add(cmb);
        JButton jbtn = new JButton("confirm");
        jp.add(jbtn);
        frame.add(jp);
        frame.setBounds(300, 200, 400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = (String) cmb.getSelectedItem();
                switch (msg) {
                    case "Publication":
                        new LibraryPanel(library);
                        frame.setVisible(false);

                        break;
                    case "Reader":
                        new ReaderPanel(library);
                        frame.setVisible(false);
                        break;
                    default:
                        break;
                }
            }
        });


    }
}





