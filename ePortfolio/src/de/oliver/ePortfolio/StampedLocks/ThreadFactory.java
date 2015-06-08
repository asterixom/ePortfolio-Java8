package de.oliver.ePortfolio.StampedLocks;

import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;



public class ThreadFactory {

	public static void createThread(int anzahl, Runnable run) {
		for (int i = 0; i < anzahl; i++) {
			new Thread(run).start();
		}
	}

	public static void main(String[] args) {
		SharedResource sr = new SharedResource();
		StampedLock lock = new StampedLock();
		Thread ct = Thread.currentThread();
		ThreadFactory.createThread(1, () -> {
			try {
				ct.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
			long complete = System.currentTimeMillis();
			long time;
			ArrayList<Long> list = new ArrayList<>();
			
			//START writing
			for(int i=0;i<1000000;i++){
				time = System.currentTimeMillis();
				long stamp = lock.writeLock();
				try {
					sr.setWert((int) (Math.random() * 10),stamp);
				} finally {
					lock.unlock(stamp);
				}
				list.add(System.currentTimeMillis()-time);
			}
			//END writing
			list.stream().min(Long::compareTo).ifPresent(System.out::print);
			System.out.println(" ms MIN");
			list.stream().max(Long::compareTo).ifPresent(System.out::print);
			System.out.println(" ms MAX");
			sr.sum = 0;
			list.stream().forEach((a)->sr.sum+=a);
			System.out.println(sr.sum+" ms SUM");
			sr.sum = 0;
			list.parallelStream().forEach((a)->sr.sum+=a);
			System.out.println("\t"+sr.sum+" ms SUM parallel");
			System.out.println((System.currentTimeMillis()-complete)+" ms COMPLETE");
			System.out.println((sr.getUngleich()/sr.getGleich()*100)+"% FEHLER");
			System.exit(0);
		});
		ThreadFactory.createThread(10, () -> {
			try {
				ct.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//START reading
			while(true){
//				long stamp = 0;
				
				
//			 long stamp = lock.readLock();
//				try {
//					int wert = sr.getWert(stamp);
//					int copy = sr.getCopy(stamp);
//					if (wert != copy) {
//						sr.countUG();
//					}else{
//						sr.countG();
//					}
//				} finally {
//					 lock.unlock(stamp);
//				}
				
				
				 long stamp = lock.tryOptimisticRead();
				 int wert = sr.getWert(stamp);
					int copy = sr.getCopy(stamp);
					if (lock.validate(stamp)) {
						sr.countUG();
					}else{
						sr.countG();
					}
					
					
//				try{
//					Thread.sleep(1L);
//				}catch(InterruptedException e){
//					Thread.currentThread().interrupt();
//				}
			}
			//END reading
			
		});
		System.out.println("GO");
	}
}
