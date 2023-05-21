package com.learn.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorFeature {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		StringBuilder concat = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(concat.toString());
		
		Set<String> set = list.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println(set);
		
		
		
		java.util.Map<Boolean, List<String>> a = list.stream().collect(Collectors.partitioningBy(input -> input.equals("a")));
		System.out.println(a);
	}

}
