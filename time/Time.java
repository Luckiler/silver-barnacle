package time;

import aquarium.Aquarium;

public class Time extends Thread {
	
	private Aquarium aquarium;
	
	public Time(Aquarium aquarium) {
		this.aquarium = aquarium;
	}
	
	public void run() {
		//aquarium.go()
		try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}