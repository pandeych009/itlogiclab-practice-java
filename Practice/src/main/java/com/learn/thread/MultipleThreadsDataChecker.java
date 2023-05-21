package com.learn.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MultipleThreadsDataChecker {

	private static String ELEMENT_TO_CHECK = "KEY1:KEY2";

	public static void main(String[] args) {
		List<CustomObject> list = new CopyOnWriteArrayList<CustomObject>(); 
		new EvectValuesFromCustomObject(list);
		while(true){
			String[] values = ELEMENT_TO_CHECK.split(":");
			CustomObject ob = new CustomObject();
			for(int index =0;index<ELEMENT_TO_CHECK.length(); index++){
				ob.addValue(values[0], ThreadLocalRandom.current().nextInt(0, 1000));
				ob.addValue(values[1], ThreadLocalRandom.current().nextInt(0, 1000));
			}
			ob.setCurrentTime(System.currentTimeMillis());
			list.add(ob);
			System.out.println("Element added to list: "+ob);
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
