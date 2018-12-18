package aquarium.items;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fish extends MobileItem {
	@Override
	public void draw(Graphics g) {
	g.drawImage(image, position.x, position.y, width, height, null);
			
}
	public Fish(Point point, int width, int height){
		this.position = point;
		this.width = width;
		this.height = height;
		if (image == null) {
			try {
				image = ImageIO.read(new File("Poisson.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}