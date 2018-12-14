package aquarium.items;

import java.awt.Point;
import java.util.Collection;

import aquarium.Mobile;
import random.RandomNumber;
import aquarium.Aquarium;

public abstract class MobileItem extends AquariumItem implements Mobile
{
	// Base speed in unit per second
	static final int BASE_SPEED = 10;
	
	public boolean move(Point destination)
	{
		double d = this.position.distance(destination);
		// If we're close enough to the destination just snap there
		if (d < BASE_SPEED /* * deltaTime */)
		{
			this.position.setLocation(destination);
			return true;
		}
		double dx = (destination.x - this.position.x) / d;
		double dy = (destination.y - this.position.y) / d;
		
		this.position.setLocation(dx * BASE_SPEED /* * deltaTime */, dy * BASE_SPEED /* * deltaTime */);
		
		return false;
	}
	
	public Point target(Collection<AquariumItem> neighbours)
	{
		return RandomNumber.randomPoint(0, Aquarium.WIDTH - this.width, 0, Aquarium.HEIGHT - this.height);
	}
	
	public static Image {
		
	}
}
