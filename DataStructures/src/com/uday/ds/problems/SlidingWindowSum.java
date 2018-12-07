package com.uday.ds.problems;

import java.util.HashMap;

public class SlidingWindowSum {
	
	public static int maxSumForConsecutiveElem(int[] a, int k){
		int max = 0;
		for(int i=0; i<k; i++){
			max+=a[i];
		}
		for(int i =k; i <a.length; i++){
			int sum = max +a[i] - a[i-k];
			max = Math.max(max, sum);
		}
		return max;
		
	}
	
	public static void main(String[] args){
		int arr[] = {10,20,30,40,20};
		System.out.println(maxSumForConsecutiveElem(arr,2));
		distinctDigits(arr,4);
	}
	
	public static void distinctDigits(int[] a, int k){
		HashMap<Integer,Integer> countM = new HashMap<>();
		for(int i=0; i<k; i++){
			countM.put(a[i], 
					(null!=countM.get(a[i])?countM.get(a[i])+1:1));
		}
		countM.forEach((e,v) -> System.out.print(e+","));
		System.out.println();
		for(int i =k; i <a.length; i++){
			countM.put(a[i], 
					(null!=countM.get(a[i])?countM.get(a[i])+1:1));
			Integer oldE = countM.get(a[i-k]);
			if(oldE.intValue()==1){
				countM.remove(a[i-k]);
			}
			else{
				countM.put(a[i-k], oldE-1);
			}
			countM.forEach((e,v) -> System.out.print(e+","));
			System.out.println();
		}		
	}

}
