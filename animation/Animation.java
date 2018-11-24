package animation;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import aquarium.Aquarium;

public class Animation extends JFrame {
	
	public static final int WIDTH = 800, HEIGHT = 400;

	private static final long serialVersionUID = 1L;
	
	public Animation(String title) {
	setTitle(title);
	setVisible(true); 
	setSize(WIDTH, HEIGHT);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);
	getContentPane().setBackground(Color.BLUE);
	
	JPanel Aquarium =new Aquarium();
	add(Aquarium);
	
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Quit this aquarium?", "Quit?", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }
}