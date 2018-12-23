package aquarium.items;

import java.awt.Point;
import java.awt.geom.Point2D;

import aquarium.Mobile;
import random.RandomNumber;
import aquarium.Aquarium;
import time.Time;

public abstract class MobileItem extends AquariumItem implements Mobile
{
	// Base speed in unit per second
	static final int BASE_SPEED = 50;
	public boolean hasTarget = false;
	private Point2D.Double target;

	public void move()
	{
		double d = this.position.distance(target);
		// If we're close enough to the destination just snap there
		if (d < BASE_SPEED * Time.deltaTime)
		{
			this.position.setLocation(target);
			this.hasTarget = false;
		} else {
			double dx = ((target.x - this.position.x) / d)  * BASE_SPEED  * Time.deltaTime;
			double dy = ((target.y - this.position.y) / d)  * BASE_SPEED  * Time.deltaTime;

			this.position.setLocation(this.position.getX() + dx, this.position.getY() + dy);
		}
	}

	public void generateTarget()
	{
		this.target = RandomNumber.randomPoint(0, Aquarium.WIDTH - this.width, 0, Aquarium.HEIGHT - this.height);
		this.hasTarget = true;
	}
	
	
}
