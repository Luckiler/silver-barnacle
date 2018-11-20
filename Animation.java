import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Animation extends JFrame
{

    Animation()
    {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener(){        
            @Override
            public void windowClosing(WindowEvent arg0) {
                JOptionPane.showConfirmDialog(null, "Do you want to close this wonderful aquarium", "Quit?", JOptionPane.YES_NO_OPTION);
            }
        });
    }
}