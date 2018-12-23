package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import aquarium.Aquarium;
import time.Time;

public class Animation extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Animation(String title) {
        setTitle(title);
        setVisible(true);
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        Aquarium aquarium = new Aquarium();
        add(aquarium);

        Time time = new Time(aquarium);
        Thread timeT = new Thread(time);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e) {
                    int choice = JOptionPane.showConfirmDialog(null, "Quit this aquarium?", "Quit?", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        synchronized (time) {
                            time.running = false;
                        }
                        dispose();
                    }
                }
            });
        timeT.start();
    }

}