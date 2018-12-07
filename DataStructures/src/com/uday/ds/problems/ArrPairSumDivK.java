package com.uday.ds.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class ArrPairSumDivK {
	
	public static boolean exist(int[] a, int k){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i <a.length;  i++){
			int req = k - (a[i]%k);
			Integer pair_idx = map.get(req);
			if(null!=pair_idx){
				map.remove(req);
				System.out.println(pair_idx+","+i);
			}
			else{
				map.put(a[i]%k, i);
			}
		}
		return (map.size()==0);
	}
	
	public static void main(String[] args){
		int arr[] =  {92, 75, 65, 48, 45, 35}; 
	    int k = 10; 
		System.out.println(exist(arr,k));
		findDivisor(16);
	}
	
	
	public static boolean remainder(int[] a, int k){
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i <a.length;  i++){
			if(a[i]<k){
				
			}
			if(a[i]>=k){
				Set<Integer> divs = findDivisor(a[i]-k);
				
			}
			
		}
		return (map.size()==0);
	}
	
	
	public static Set<Integer> findDivisor(int n){
		Set<Integer> divs = new TreeSet<>();
		for(int i =1; i<=Math.sqrt(n); i++){
			if(n%i==0){
				divs.add(i);
				divs.add(n/i);
			}
		}
		divs.forEach(d -> System.out.print(d+","));
		return divs;
	}

}
