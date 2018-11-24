package aquarium.items.factories;

import aquarium.items.AquariumItem;

public abstract class AquariumItemFactory<T extends AquariumItem> {
	public abstract T newItem();
}
