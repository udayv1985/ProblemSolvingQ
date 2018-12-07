package com.uday.dp;

import java.util.*;

public class WordBreak {
	
	static Set<String> dictionary = new HashSet<>();
	
	static Map<String,Boolean> mem = new LinkedHashMap<>();
	
	static{
		dictionary.add("i");
		dictionary.add("google");
		dictionary.add("blue");
		dictionary.add("as");
	}
	
	public static boolean isValid(String str){
		if(mem.containsKey(str)){
			return mem.get(str);
		}
		boolean valid = false;
		for(int i =1; i<=str.length(); i++){
			if(dictionary.contains(str.substring(0, i))){
				if(i==str.length() || isValid(str.substring(i))){
					valid = true;
					break;
				}
			}
		}
		mem.put(str,valid);
		return valid;
	}
	
	public static void main(String[] args){
		System.out.println(isValid("googleasblueias"));
		mem.forEach((k,v) -> System.out.println(k+" ; "+v));
	}

}
