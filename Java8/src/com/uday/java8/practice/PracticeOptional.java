package com.uday.java8.practice;

import java.util.*;

public class PracticeOptional {
	
	static class Node{
		int data;
		
		public Node(int d){
			data = d;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
		
	}
	
	public static void main(String[] args){
		String s = null;
		Optional<String> optStr = Optional.ofNullable(s);
		
		
		
		System.out.println(optStr.toString());
		System.out.println(optStr.orElse(new String("xyz")));
		
		s = "abc";
		
		optStr = Optional.of(s);
		
		optStr.ifPresent(str -> str.toUpperCase());
		System.out.println(optStr.get());
		
		List<Node> list = new ArrayList<>();
		list.add(new Node(1));
		list.add(new Node(2));
		list.forEach(a -> a.setData(a.getData()+10));
		list.forEach(a->{System.out.println(a.getData());});
		
	}

}
