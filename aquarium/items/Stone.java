package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

public class Stone extends AquariumItem
{
	public static final int MIN_WIDTH = 1, MAX_WIDTH = 5;
	
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
}