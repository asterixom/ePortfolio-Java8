package de.oliver.ePortfolio.java8.StampedLocks;


public class SharedResource {
	private int wert = 0;
	private int wertcopy = 0;
	private volatile int ungleich = 0;
	private volatile int gleich = 0;
	public long sum = 0;
	
	public int getWert(long... garbage){
		return wert;
	}
	
	public int getCopy(long... garbage){
		return wertcopy;
	}
	
	public void setWert(int w, long... garbage){
		wert=w;
//		try {
//			Thread.sleep(10L);
//		} catch (InterruptedException e) {
//			Thread.currentThread().interrupt();
//			e.printStackTrace();
//		}
		wertcopy=w;
	}
	
	public void countUG(){
		ungleich++;
	}
	
	public void countG(){
		gleich++;
	}
	
	public int getUngleich(){
		return ungleich;
	}

	public int getGleich() {
		return gleich;
	}
}
