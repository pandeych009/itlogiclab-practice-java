package com.learn.algo.client;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.learn.utils.PracticeUtils;

public class ReArrangeArray {
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 7, 18, 13, 19, 4, 20, 21, 14};
		restructure(arr);
	}

	
	public static void restructure(int arr[]) {
		if(arr.length <=0  )
			return;
		
		for(int index_even=0, index_odd=1; index_even < arr.length; ) {
			int even_temp = -1, odd_temp=-1;
			if(index_even >= arr.length || index_odd >= arr.length)break;
			
			 if(arr[index_even] % 2 != 0 && index_even % 2 == 0) {
				even_temp=index_even;
			}else {
				index_even++;
			}
			
			if(arr[index_odd] %2 ==0 && index_odd % 2 != 0) {
				odd_temp = index_odd;
			}else {
				index_odd++;
			}
			
			
			if(even_temp != -1 && odd_temp != -1) {
				int temp = arr[even_temp];
				arr[even_temp]=arr[odd_temp];
				arr[odd_temp]=temp;
				
				even_temp = odd_temp = -1;
				index_even = index_even+2;
				index_odd=index_odd+2;
				
				
			}
		}
		
		PracticeUtils.print(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		
	}
}
