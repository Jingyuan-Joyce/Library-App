package ui;

import model.Library;
import model.Publication;
import model.Reader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReaderInformationPanel extends JDialog {
    public ReaderInformationPanel(int num, Library library) {
        for (int i = 0; i < num; i++) {
            JFrame frame = new JFrame("READER INFORMATION");
            setModal(true);
            frame.setSize(400, 200);
            JPanel jp = new JPanel(new GridLayout(3, 2));
            frame.add(jp);
            frame.setBounds(300, 200, 600, 300);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            JLabel jl1 = new JLabel("Name:");
            JTextField jtf1 = new JTextField(8);
            JLabel jl2 = new JLabel("Reader ID:");
            JTextField jtf2 = new JTextField(8);
            jp.add(jl1);
            jp.add(jtf1);
            jp.add(jl2);
            jp.add(jtf2);
            JButton jb = new JButton("Confirm");
            jp.add(jb, BorderLayout.SOUTH);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Reader reader = new Reader(null,0);
                    reader.setReaderName(jtf1.getText());
                    reader.setReaderId(Integer.parseInt(jtf2.getText()));
                    library.addCustomer(reader);
                    library.savable("data.txt");
                    JOptionPane.showMessageDialog(null, "Successfully added", "Attention", JOptionPane.PLAIN_MESSAGE);
                    frame.setVisible(false);


                }
            });

        }
    }

}




