package time;

import aquarium.Aquarium;

public class Time extends Thread {
	
	private Aquarium aquarium;
	public static long deltaTime;
	private long lastTime;
	
	public Time(Aquarium aquarium) {
		this.aquarium = aquarium;
		this.lastTime = System.nanoTime();
	}
	
	public void run() {
		this.deltaTime = this.lastTime - System.nanoTime();
		this.lastTime = System.nanoTime();

		aquarium.simulate();
		try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}