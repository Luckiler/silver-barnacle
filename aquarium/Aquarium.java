package aquarium;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import aquarium.items.AquariumItem;
import aquarium.items.Fish;
import aquarium.items.factories.*;

public class Aquarium extends JPanel
{
	private static final long serialVersionUID = 1L;
	public static final int NB_STONES = 10, NB_SEAWEED = 5;
	// The size of the virtual aquarium
	public static final int WIDTH = 1000, HEIGHT = 1000;
	
    private ArrayList<AquariumItem> items = new ArrayList<AquariumItem>();

    public void fill(AquariumItem item)
    {
        this.items.add(item);
    }
    
    public Aquarium() {
    	
    	setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("fond océan.jpg"));
        add(background);
        background.setLayout(new FlowLayout());
    	
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
    	
    	Fish fish1 = new Fish(new Point(10, 20), 50, 50);
    	Fish fish2 = new Fish(new Point(150, 200), 50, 50);
    	Fish fish3 = new Fish(new Point(125, 100), 50, 50);
    	Fish fish4 = new Fish(new Point(300, 300), 50, 50);
    	Fish fish5 = new Fish(new Point(400, 400), 50, 50);
    	
    	fill(fish1);
    	fill(fish2);
    	fill(fish3);
    	fill(fish4);
    	fill(fish5)
;    }
    
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
    