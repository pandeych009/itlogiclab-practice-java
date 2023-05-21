package com.learn.datastruct;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataStructureGenaral {
	
	public static void main(String[] args) {
		List<Integer> list = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).distinct().limit(10).boxed().collect(Collectors.toList());	
		print(list);
		
	}
	
	public static void findMinAndMax(List<Integer> list) {
		int min, max;
		List<Integer> numbers = new ArrayList<>();
		
		
		 
	}
	
	public static void print(List<?> list) {
		list.forEach(input -> System.out.print(input + ", "));
	}

}
