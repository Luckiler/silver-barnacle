package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Stone extends AquariumItem
{
	public static final int MIN_WIDTH = 10, MAX_WIDTH = 50;
	
    public Stone(int width) {
		this.width = width;
		this.height = width;
		if (image == null) {
			try {
			image = ImageIO.read(new File("Rock .png"));
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

    @Override
    public void draw(Graphics g) {
    	g.drawImage(image, position.x, position.y, width, height, null);
        
    }
}