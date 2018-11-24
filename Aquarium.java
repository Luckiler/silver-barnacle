import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

public class Aquarium extends JPanel
{
	static int NB_STONES, NB_SEAWEED;
	
    private ArrayList<AquariumItem> items = new ArrayList<AquariumItem>();

    Aquarium()
    {

    }

    public void fill(AquariumItem item)
    {
        this.items.add(item);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        for(int i = 0; i < items.size(); i++)
        {
            items.get(i).draw(g);
        }
    }
}

abstract class AquariumItem
{
    protected Point position;
    protected int width;
    protected int height;

    AquariumItem(int width)
    {
        this.width = width;
        this.height = width / 3;
    }

    public void setPosition(Point p)
    {
        this.position = p;
    }

    public Rectangle rectangle()
    {
        return new Rectangle(this.position.x, this.position.y, this.width, this.height);
    }

    public abstract void draw (Graphics g);
    
    abstract int getMinWidth();
    abstract int getMax_Width();
    
    public boolean intersects(Collection<AquariumItem> c)
    {
        for (AquariumItem a : c) {
            if (a.rectangle().intersects(this.rectangle()))
            {
                return true;
            }
        }
        return false;
    }
}

abstract class AquariumItemFactory<T extends AquariumItem>
{
	public abstract T newItem();
}

class Stone extends AquariumItem
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
}

// TODO Make it look like an actual seaweed
class Seaweed extends AquariumItem
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
}
