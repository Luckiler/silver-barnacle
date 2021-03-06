package random;

import java.awt.Point;
import java.awt.geom.Point2D;

public class RandomNumber
{
	public static int randomValue(int min, int max)
	{
		return (int)(Math.random() * (max - min + 1)) + min;
	}
	
	public static Point2D.Double randomPoint(int min_x, int max_x, int min_y, int max_y)
	{
		return new Point2D.Double(randomValue(min_x, max_x), randomValue(min_y, max_y));
	} 
}