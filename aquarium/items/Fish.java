package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

public class Fish extends MobileItem {

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(this.position.x, this.position.y, this.width, this.height);
	}

}
