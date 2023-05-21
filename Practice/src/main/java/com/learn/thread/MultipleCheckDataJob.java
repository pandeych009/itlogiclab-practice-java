package com.learn.thread;

import java.util.Map;

public class MultipleCheckDataJob implements Runnable {

	public MultipleCheckDataJob(Map<String, Object> values) {
		
	}
	
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+": Start Execution");
		
		
		
		System.out.println(Thread.currentThread().getName()+": End Execution");
	}

}
