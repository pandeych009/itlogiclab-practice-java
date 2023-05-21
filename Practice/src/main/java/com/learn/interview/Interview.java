package com.learn.interview;

public class Interview {
	
	public static void main(String[] args) {
		int[] arr = {5,7,11,45,24,18,3,2, 4, 6,2};
		//int[] arr = {1,2,3,4};
		int evenPos = -1, oddPos = -1;
		int index_i = 0, index_j=1;
		
		print(arr);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		while(true){
			if(index_i%2 == 0 && arr[index_i] % 2 != 0){
				evenPos=index_i;
			}else index_i++;
			
			
			if(index_j%2 != 0 && arr[index_j] % 2 == 0){
				oddPos = index_j;
			}else index_j++;
			
			if(evenPos != -1 && oddPos != -1){
				int temp = arr[evenPos];
				arr[evenPos]=arr[oddPos];
				arr[oddPos]=temp;
				
				evenPos = oddPos = -1;
				print(arr);
				index_j=index_j+2;
				index_i=index_i+2;
				
			}
			if(index_j >= arr.length)
				break;
			
		}
		System.out.println("%%%%%%%%%%%%%%%%%%5");
		print(arr);
	}
	public static void print(int[] elem){
		StringBuilder builder = new StringBuilder();
		for(int index = 0; index < elem.length; index++){
			//builder.append("{"+index +", "+ elem[index]+"}");
			builder.append(elem[index]);
			if(index <elem.length-1){
				builder.append(",");
			}
		}
		System.out.println(builder.toString());
	}
}
