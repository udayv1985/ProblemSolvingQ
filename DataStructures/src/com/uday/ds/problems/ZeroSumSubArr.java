package com.uday.ds.problems;

public class ZeroSumSubArr {
	
	public static void printAll(int a[]){
		int sum = a[0];
		int startIdx = 0;
		for(int i=1; i<a.length; i++){
			sum+=a[i];
			if(sum==0){
				System.out.println(startIdx+","+i);
			}
			//while()
		}
	}

}
