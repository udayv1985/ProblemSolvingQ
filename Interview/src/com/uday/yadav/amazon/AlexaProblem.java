package com.uday.yadav.amazon;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AlexaProblem {
	
	public static List<List<Integer>> getNearest(List<List<Integer>> all, int num, int n){
		List<List<Integer>> solution = null;
		Map<List<Integer>,Double> map = new LinkedHashMap<>();
		
		for(List<Integer> xy : all){
			map.put(xy, getDistance(xy));
		}
		
		map = 
			    map.entrySet().stream().
			    sorted(Entry.comparingByValue()).
			    collect(Collectors.toMap(Entry::getKey, Entry::getValue,
			                             (e1, e2) -> e1, LinkedHashMap::new));
		
		
		
		return solution;
	}
	
	private static double getDistance(List<Integer> xy){
		return Math.sqrt(Math.pow(xy.get(0), 2)+Math.pow(xy.get(1), 2));
	}
	
	public static void main(String[] args){
		List<List<Integer>> all = new ArrayList<>();
		List<Integer> t = null;
		for(int i =1; i<5; i++){
			t = new ArrayList<>();
			if(i==3){
				t.add(0);
				t.add(-1);
			}
			else{
				t.add(i);
				t.add(i);
			}
			all.add(t);
		}
		List<List<Integer>> r = getNearest(all,2,all.size());
	//	r.forEach(a->a.forEach(b->b.intValue() ));
		
		
	}

}
