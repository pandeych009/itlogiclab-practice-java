package com.learn.features;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntStreamFeatureImpl {

	public static void main(String[] args) {
		intStreamExample();
	}

	public static void intStreamExample() {
		//range and rangeClosed
		IntStream range = IntStream.range(1, 10);
		print(range);
		range = IntStream.rangeClosed(1, 10);
		print(range);
		final int startValue = 0;
		//Calculation on start value
		range = IntStream.iterate(startValue, input -> input+2).limit(10);
		print(range);
		//No calculation on previous value/start value
		range = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).distinct().limit(10);
		print(range);
		
		//Mapping example
		
		Stream<Integer> stream = IntStream.range(1,  6).boxed();
		stream.forEach(input -> System.out.println(input +", "));
		System.out.println("\n");
		
		
		IntStream random = new Random().ints(1, 10).distinct().limit(10);
		print(random);
		
		
	}
	
	
	
	public static void print(IntStream stream) {
		stream.forEach(input -> System.out.print(input+", "));
		System.out.println("\n");
	}

}
