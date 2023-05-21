package com.learn.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadPool {

	private int threads;
	private final Worker[] worker;
	private final BlockingQueue<Object> queue;



	public ThreadPool(int threads) {
		super();
		this.threads = threads;
		this.worker = new Worker[threads];
		this.queue = new PriorityBlockingQueue<Object>();
		for(int index = 0; index < threads; index++) {
			worker[index] = new Worker();
			worker[index].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}


	private class Worker extends Thread{
		public void run() {
			Runnable task;
			while(true) {
				synchronized (queue) {
					while(queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					task = (Runnable) queue.poll();
				}
				task.run();
			}
		}
	}	

}


