package aquarium;

import java.awt.Point;
import java.util.Collection;

import aquarium.items.AquariumItem;

public interface Mobile {
	public boolean move(Point destination);
	void generateTarget(Collection<AquariumItem> neighbours);
}
