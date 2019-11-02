package com.uday.ds.problems;

import java.util.*;

public class ZeroSumSubArr {
	
	public static void printAll(int a[]){
		int sum = 0;
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0; i<a.length; i++){
			sum+=a[i];
			if(sum == 0){
				System.out.println("sub array: 0 : "+i);
			}
			List<Integer> idxs = map.get(sum);
			if(null == idxs){
				idxs = new ArrayList<>();
			}
			else{
				for(Integer idx: idxs){
					System.out.println("sub array: "+(idx.intValue()+1) +" : "+i);
				}

			}
			idxs.add(i);
			map.put(sum,idxs);
		}
		System.out.println(map);
	}

	public static void main(String[] args){
		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		printAll(arr);
	}

}
