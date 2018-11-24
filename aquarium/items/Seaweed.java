package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

//TODO Make it look like an actual seaweed
public class Seaweed extends AquariumItem
{
	static int MIN_WIDTH, MAX_WIDTH;
	
	Seaweed(int width)
	{
		super(width);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(this.position.x, this.position.y, this.width, this.height);
		
	}

	@Override
	int getMinWidth() {
		return Seaweed.MIN_WIDTH;
	}

	@Override
	int getMax_Width() {
		return Seaweed.MAX_WIDTH;
	}
}