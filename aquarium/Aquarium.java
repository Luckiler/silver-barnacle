package aquarium;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

import javax.swing.JPanel;

import aquarium.items.AquariumItem;
import aquarium.items.ItemUpdateInfo;
import aquarium.items.factories.*;

public class Aquarium extends JPanel
{
    private static final long serialVersionUID = 1L;
    public static final int NB_STONES = 10, NB_SEAWEED = 5, NB_FISH = 10;
    // The size of the virtual aquarium
    public static final int WIDTH = 1000, HEIGHT = 1000;
    // private ArrayList<AquariumItem> items = new ArrayList<AquariumItem>();
    private HashMap<UUID, AquariumItem> items = new LinkedHashMap<>();
    private boolean standalone;
    private Socket socket;

    public void fill(AquariumItem item)
    {
        this.items.put(item.id, item);
    }

    public Aquarium()
    {
        this.standalone = true;

        this.setBackground(Color.BLUE);
        int i;
        StoneFactory stoneFactory = new StoneFactory();
        for (i = 0; i < NB_STONES; i++) {
            this.fill(stoneFactory.newItem());
        }

        SeaweedFactory seaweedFactory = new SeaweedFactory();
        for (i = 0; i < NB_SEAWEED; i++) {
            this.fill(seaweedFactory.newItem());
        }

        FishFactory fishFactory = new FishFactory();
        for (i = 0; i < NB_FISH; i++)
        {
            this.fill(fishFactory.newItem());
        }
    }

    public Aquarium(String host, int port) throws IOException {
        standalone = false;
        connect(host, port);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        synchronized (items)
        {
            for(Map.Entry<UUID, AquariumItem> aquariumItemEntry : this.items.entrySet())
            {
                aquariumItemEntry.getValue().draw(g);
            }
        }
    }

    class updateItems implements Runnable
    {
        Map<UUID, AquariumItem> items;
        Map<UUID, ItemUpdateInfo> itemUpdates;

        public updateItems(Map<UUID, AquariumItem> aquariumItems, Map<UUID, ItemUpdateInfo> itemUpdateInfoMap)
        {
            items = aquariumItems;
            itemUpdates = itemUpdateInfoMap;
        }

        @Override
        public void run() {
            synchronized (items)
            {
                for (Map.Entry<UUID, AquariumItem> aquariumItemEntry : this.items.entrySet())
                {
                    for (Map.Entry<UUID, ItemUpdateInfo> itemUpdateInfoEntry : itemUpdates.entrySet())
                    {
                        if (aquariumItemEntry.getKey() == itemUpdateInfoEntry.getKey())
                        {
                            aquariumItemEntry.getValue().update(itemUpdateInfoEntry.getValue());
                        }
                    }
                }
            }
        }
    }

    public void connect(String host, int port) throws IOException
    {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));
    }
}
    