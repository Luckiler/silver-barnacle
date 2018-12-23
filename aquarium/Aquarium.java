package aquarium;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.Socket;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aquarium.items.MobileItem;
import time.Time;

import aquarium.items.AquariumItem;
import aquarium.items.ItemUpdateInfo;
import aquarium.items.factories.*;

public class Aquarium extends JPanel
{
    private static final long serialVersionUID = 1L;
    public static final int NB_STONES = 10, NB_SEAWEED = 5, NB_FISH = 10;
    public static final int WIDTH = 1000, HEIGHT = 1000;
    private HashMap<UUID, AquariumItem> items = new LinkedHashMap<>();
    private boolean standalone;
    private Socket socket;
    private Time time;

    public void fill(AquariumItem item)
    {
        this.items.put(item.id, item);
    }

    public Aquarium()
    {
        this.standalone = true;

        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("fond ocean.jpg"));
        add(background);
        background.setLayout(new FlowLayout());

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

    public void simulate() {
        for (Map.Entry<UUID, AquariumItem> aquariumItemEntry : this.items.entrySet())
        {
            try {
                MobileItem mobileItem = (MobileItem) aquariumItemEntry.getValue();
                if (mobileItem.hasTarget) {
                    mobileItem.move();
                } else {
                    mobileItem.generateTarget();
                    mobileItem.move();
                }
            } catch (ClassCastException e) {

            }
        }
    }

    public void connect(String host, int port) throws IOException
    {
        socket = new Socket();
        socket.connect(new InetSocketAddress(host, port));
    }
}
    