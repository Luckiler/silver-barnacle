import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Aquarium extends JPanel
{

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

    public boolean intersects(Collection<AquariumItem> c)
    {
        // TODO implement this
    }
}

class Stone extends AquariumItem
{
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
