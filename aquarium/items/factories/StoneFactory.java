package aquarium.items.factories;

import animation.Animation;
import aquarium.items.Stone;
import random.RandomNumber;

public class StoneFactory extends AquariumItemFactory<Stone>
{

	@Override
	public Stone newItem() {
		Stone newStone = new Stone(RandomNumber.randomValue(Stone.MIN_WIDTH, Stone.MAX_WIDTH));
		newStone.setPosition(RandomNumber.randomPoint(0, Animation.HEIGHT, 0, Animation.WIDTH));
		return newStone;
	}
	
}