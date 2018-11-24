package aquarium.items;

import java.awt.Color;
import java.awt.Graphics;

public class Stone extends AquariumItem
{
	static int MIN_WIDTH, MAX_WIDTH;
	
    Stone(int width)
    {
        super(width);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        // Different from the "consigne" but looks better
        g.fillOval(this.position.x, this.position.y, this.width, this.height);
    }

	@Override
	int getMinWidth() {
		return Stone.MIN_WIDTH;
	}

	@Override
	int getMax_Width() {
		return Stone.MAX_WIDTH;
	}
}