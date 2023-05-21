package com.learn.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.learn.algo.nonlinear.BinarySearchTree;
import com.learn.algo.nonlinear.operation.TreeOperation;
import com.learn.utils.PracticeUtils;

public class TreeClient {

	public static void main1(String[] args) {


	}

	private static void testTree() {
		TreeOperation operations = new BinarySearchTree();
		Set<Integer> inputSet = PracticeUtils.generateNumber(10, 50);
		List<Integer> sortedInputSet = new ArrayList(inputSet);
		Collections.sort(sortedInputSet);
		PracticeUtils.print(sortedInputSet);
		inputSet.forEach(input -> operations.add(input));
		operations.preOrderTraversal(true);
	}


	public static final String SUBSTRING_PATTERN = ",";


	public static void main(String[] args) throws IOException {

		String line = "hello world, def";
		if(Objects.nonNull(line)){
			String[] elements = line.split(SUBSTRING_PATTERN);
			if(elements.length >= 1){
				String lineToPrint = elements[0];
				for(char c: elements[1].trim().toCharArray()){
					String valueToReplace = String.valueOf(c); 
					lineToPrint = lineToPrint.replaceAll(valueToReplace, "");
				}
				System.out.print(lineToPrint);

			}else System.out.print(elements[0]);
		}


	}


}
