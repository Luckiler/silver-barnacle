package aquarium.items.factories;

import aquarium.Aquarium;
import aquarium.items.Fish;
import random.RandomNumber;

public class FishFactory extends AquariumItemFactory<Fish>
{
    @Override
    public Fish newItem() {
        return new Fish(RandomNumber.randomPoint(0, Aquarium.HEIGHT, 0, Aquarium.WIDTH),50, 50);
    }
}
