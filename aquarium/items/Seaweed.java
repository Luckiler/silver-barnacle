package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

//TODO Make it look like an actual seaweed
public class Seaweed extends AquariumItem
{
	public static final int MIN_WIDTH = 1, MAX_WIDTH = 3;
	
	public Seaweed(int width)
	{
		this.width = width;
		this.height = width * 3;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(this.position.x, this.position.y, this.width, this.height);
		
	}
}