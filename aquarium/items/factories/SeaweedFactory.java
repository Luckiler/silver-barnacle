package aquarium.items.factories;

import animation.Animation;
import aquarium.items.Seaweed;
import random.RandomNumber;

public class SeaweedFactory extends AquariumItemFactory<Seaweed> {

	@Override
	public Seaweed newItem() {
		Seaweed newStone = new Seaweed(RandomNumber.randomValue(Seaweed.MIN_WIDTH, Seaweed.MAX_WIDTH));
		newStone.setPosition(RandomNumber.randomPoint(0, Animation.HEIGHT, 0, Animation.WIDTH));
		return newStone;
	}
	
}
