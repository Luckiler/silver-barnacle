package aquarium;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import aquarium.items.AquariumItem;
import aquarium.items.factories.*;

public class Aquarium extends JPanel
{
	public static final int NB_STONES = 10, NB_SEAWEED = 5;
	
    private ArrayList<AquariumItem> items = new ArrayList<AquariumItem>();

    Aquarium()
    {
    	StoneFactory stoneFactory = new StoneFactory();
    	for (int i = 0; i < NB_STONES; i++)
    	{
    		this.fill(stoneFactory.newItem());
    	}
    	
    	SeaweedFactory seaweedFactory = new SeaweedFactory();
    	for (int i = 0; i < NB_SEAWEED; i++)
    	{
    		this.fill(seaweedFactory.newItem());
    	}
    }

    public void fill(AquariumItem item)
    {
        this.items.add(item);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        for(int i = 0; i < items.size(); i++)
        {
            items.get(i).draw(g);
        }
    }
}