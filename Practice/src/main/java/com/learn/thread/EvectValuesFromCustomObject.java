package com.learn.thread;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class EvectValuesFromCustomObject implements Runnable {
	private static final long TIME_TO_LIVE = 3000L; 
	private List<CustomObject> objects;
	public EvectValuesFromCustomObject(List<CustomObject> objects) {
		this.objects=objects;
		new Thread(this).start();

	}
	@Override
	public void run() {
		Iterator<CustomObject> iter = null;
		while(true){
			System.out.println("Element i the list: "+objects);
			if(Objects.nonNull(objects)){
				iter = objects.iterator();
				System.out.println(Thread.currentThread().getId()+": Iterator Created: ");
				while(iter.hasNext()){
					System.out.println(Thread.currentThread().getId()+": Fetch elements: ");
					CustomObject object = iter.next();
					System.out.println(Thread.currentThread().getId()+": Fetched elements: "+objects);
					long currentTime = System.currentTimeMillis();
					System.out.println(Thread.currentThread().getId()+": Current Time: "+currentTime);
					if((object.getCurrentTime() + TIME_TO_LIVE) <= currentTime ){
					}					
				}
				try {
					TimeUnit.SECONDS.sleep(4);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getId()+": Exception Occured: "+e.getMessage());
				}
			}
		}
	}

}
