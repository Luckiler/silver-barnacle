package aquarium.items;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.UUID;

public abstract class AquariumItem
{
    public Point position;
    protected int width;
    protected int height;
    public UUID id;

    public AquariumItem() {
        id = UUID.randomUUID();
    }
    protected BufferedImage image;
    
    public AquariumItem(int width)
    {
    	
    }

	public void setHeight(int height) {
		this.height = height;
	}
    
    public void setPosition(Point p){
        this.position = p;
    }

    public Rectangle rectangle()
    {
        return new Rectangle(this.position.x, this.position.y, this.width, this.height);
    }

    public abstract void draw (Graphics g);
    	
    
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

    public void update(ItemUpdateInfo updateInfo)
    {
        this.position = updateInfo.newPosition;
    }
}