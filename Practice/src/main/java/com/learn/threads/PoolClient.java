package com.learn.threads;

public class PoolClient implements Runnable{
	private int index;

	public PoolClient(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		System.out.println("Task : "+index+" is running");
		
	}

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(10);
		for(int index=0;index<10;index++) {
			pool.execute(new PoolClient(index));
		}
	}

}
