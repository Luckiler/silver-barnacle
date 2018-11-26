package aquarium.items.factories;

import aquarium.Aquarium;
import aquarium.items.Seaweed;
import random.RandomNumber;

public class SeaweedFactory extends AquariumItemFactory<Seaweed> {

	@Override
	public Seaweed newItem() {
		Seaweed newSeaweed = new Seaweed(RandomNumber.randomValue(Seaweed.MIN_WIDTH, Seaweed.MAX_WIDTH));
		newSeaweed.setPosition(RandomNumber.randomPoint(0, Aquarium.HEIGHT, 0, Aquarium.WIDTH));
		return newSeaweed;
	}
	
}
