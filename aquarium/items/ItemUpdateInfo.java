package aquarium.items;

import java.awt.*;
import java.io.Serializable;
import java.util.UUID;

public class ItemUpdateInfo implements Serializable {
    public Point newPosition;
    public UUID uuid;

    public ItemUpdateInfo(Point newPosition, UUID uuid)
    {
        this.newPosition = newPosition;
        this.uuid = uuid;
    }
}
