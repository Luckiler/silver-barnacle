package aquarium.items;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;

public abstract class AquariumItem
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