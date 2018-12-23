package aquarium.items;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fish extends MobileItem {
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
	}
	public Fish(Point2D.Double point, int width, int height){
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
	@Override
	public boolean move(Point destination) {
		return false;
	}
}