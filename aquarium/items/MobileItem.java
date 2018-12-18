package aquarium.items;

import java.awt.Point;
import java.util.Collection;

import aquarium.Mobile;
import random.RandomNumber;
import aquarium.Aquarium;
import time.Time;

public abstract class MobileItem extends AquariumItem implements Mobile
{
	// Base speed in unit per second
	static final int BASE_SPEED = 10;
	public boolean hasTarget = false;
	private Point target;
	
	public void move()
	{
		double d = this.position.distance(target);
		// If we're close enough to the destination just snap there
		if (d < BASE_SPEED * Time.deltaTime)
		{
			this.position.setLocation(target);
			this.hasTarget = false;
		}

		double dx = (target.x - this.position.x) / d;
		double dy = (target.y - this.position.y) / d;
		
		this.position.setLocation(dx * BASE_SPEED  * Time.deltaTime, dy * BASE_SPEED * Time.deltaTime);
	}
	
	public void generateTarget(Collection<AquariumItem> neighbours)
	{
		this.target = RandomNumber.randomPoint(0, Aquarium.WIDTH - this.width, 0, Aquarium.HEIGHT - this.height);
		this.hasTarget = true;
	}
	
	
}
