package time;

import aquarium.Aquarium;

public class Time extends Thread {
	
	private Aquarium aquarium;
	public static double deltaTime;
	private long lastTime;
	public boolean running = true;
	
	public Time(Aquarium aquarium) {
		this.aquarium = aquarium;
		this.lastTime = System.nanoTime();
	}
	
	public void run() {
		while(running) {
			Time.deltaTime = (System.nanoTime() - this.lastTime) / 1000000000f;
			this.lastTime = System.nanoTime();

			aquarium.simulate();
			aquarium.repaint();
		}
	}
}