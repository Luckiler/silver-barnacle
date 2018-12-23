package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//TODO Make it look like an actual seaweed
public class Seaweed extends AquariumItem
{
	private static final long serialVersionUID = 1L;
	public static final int MIN_WIDTH = 10, MAX_WIDTH = 30;
	Image Seaweed;
	
	public Seaweed(int width)
	{
		this.width = width;
		this.height = width;
		if (image == null) {
			try {
			image = ImageIO.read(new File("seaweed.png"));
			} catch (IOException e) {
			e.printStackTrace();
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
	}
}