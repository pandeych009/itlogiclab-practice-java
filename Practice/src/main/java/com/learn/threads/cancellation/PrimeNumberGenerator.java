package com.learn.threads.cancellation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator implements Runnable{

	private List<BigInteger> primes = new ArrayList<>();
	private volatile boolean cancel;
	
	public PrimeNumberGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;
		int count =0;
		while(!cancel){
			System.out.println(Thread.currentThread().getName()+": count "+count++);
			p = p.nextProbablePrime();
			System.out.println(Thread.currentThread().getName()+": Genrated prime: "+p);
			synchronized (this) {
				primes.add(p);
				System.out.println(Thread.currentThread().getName()+": Prime Added to List: "+p);
			}
		}
	}
	
	public void cancel(){
		System.out.println("Task Cancel Set");
		cancel=true;
	}
	
	public synchronized List<BigInteger> get(){
		return new ArrayList<>(primes);
	}
}
