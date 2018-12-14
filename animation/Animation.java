package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import aquarium.Aquarium;

public class Animation extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Animation(String title) {
	setTitle(title);
	setVisible(true); 
	setSize(800, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	setLocationRelativeTo(null);
	JPanel Aquarium =new Aquarium();
	add(Aquarium);
	setLayout(new BorderLayout());
    JLabel background=new JLabel(new ImageIcon("fond océan.jpg"));
    add(background);
    background.setLayout(new FlowLayout());
	
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