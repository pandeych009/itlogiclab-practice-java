package com.learn.threads.cancellation;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CancellationClient {

	public static void main(String[] args) {
		PrimeNumberGenerator p = new PrimeNumberGenerator();
		new Thread(p).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			p.cancel();
		}
		
		List<BigInteger> prime = p.get();
		prime.forEach(input -> System.out.print(input));
	}
}
