package aquarium.items;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.UUID;

public class ItemUpdateInfo implements Serializable {
    public Point2D.Double newPosition;
    public UUID uuid;

    public ItemUpdateInfo(Point2D.Double newPosition, UUID uuid)
    {
        this.newPosition = newPosition;
        this.uuid = uuid;
    }
}
