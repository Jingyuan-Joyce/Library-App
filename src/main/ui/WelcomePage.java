package ui;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.IOException;

public class WelcomePage {

    public WelcomePage() {
        JFrame jf = new JFrame("Library Welcome Page");
        jf.setBounds(300, 100, 400, 700);
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("library.png"));
        JLabel label = new JLabel(imageIcon);
        JPanel jp = new JPanel();
        JLabel jl = new JLabel("Welcome to the library!");
        JButton jbtn = new JButton("Click here");
        JButton musicButton = new JButton("Play Music");
        jp.add(jl);
        jp.add(label);
        jf.add(jp);
        jp.add(jbtn);
        jp.add(musicButton);
        jp.setBackground(Color.white);
        jf.setVisible(true);


        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerOrPub();
                jf.setVisible(false);
            }
        });
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("Joana Navarro-Thank You, Next的副本.wav");
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();;
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }


            }
        });
    }



    public static void main(String[] args) {
        new WelcomePage();

    }
}
