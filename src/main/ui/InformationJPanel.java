package ui;

import model.Library;
import model.Publication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InformationJPanel extends JDialog {

    InformationJPanel(Publication p, int times, Library library) {
        for (int i = 0; i < times; i++) {
            JFrame frame = new JFrame("INFORMATION");
            setModal(true);
            frame.setSize(400, 200);
            JPanel jp = new JPanel(new GridLayout(4, 2));
            frame.add(jp);
            frame.setBounds(300, 200, 600, 300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JLabel jl1 = new JLabel("Name:");
            JTextField jtf1 = new JTextField(8);
            JLabel jl2 = new JLabel("Number:");
            JTextField jtf2 = new JTextField(8);
            JLabel jl3 = new JLabel("Page/Length:");
            JTextField jtf3 = new JTextField(8);
            jp.add(jl1);
            jp.add(jtf1);
            jp.add(jl2);
            jp.add(jtf2);
            jp.add(jl3);
            jp.add(jtf3);
            JButton jb = new JButton("Confirm");
            jp.add(jb, BorderLayout.SOUTH);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p.setName(jtf1.getText());
                    p.setNumber(Integer.parseInt(jtf2.getText()));
                    p.setLength(Integer.parseInt(jtf3.getText()));
                    library.addPublication(p);
                    library.savable("data.txt");
                    JOptionPane.showMessageDialog(null, "Successfully added", "Attention", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);


                }
            });
        }

    }


}

