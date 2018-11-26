package aquarium;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import aquarium.items.AquariumItem;
import aquarium.items.factories.*;

public class Aquarium extends JPanel
{
	public static final int NB_STONES = 10, NB_SEAWEED = 5;
	// The size of the virtual aquarium
	public static final int WIDTH = 1000, HEIGHT = 1000;
	
    private ArrayList<AquariumItem> items = new ArrayList<AquariumItem>();

    public void fill(AquariumItem item)
    {
        this.items.add(item);
    }
    public Aquarium()
    {
    	this.setBackground(Color.BLUE);
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