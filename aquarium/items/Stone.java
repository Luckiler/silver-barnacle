package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Stone extends AquariumItem
{
	public static final int MIN_WIDTH = 10, MAX_WIDTH = 50;
	
    public Stone(int width)
    {
        this.width = width;
        this.height = width / 3;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        g.fillOval(this.position.x, this.position.y, this.width, this.height);
    }
    
    public static void Image() {
    }	
    	
    JLabel Label = new JLabel(new ImageIcon(getImage().getClass().getResource("image/Rock.png")));
	
	private static Object getImage() {
		return null;
	}

}