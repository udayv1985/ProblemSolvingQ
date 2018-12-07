package com.uday.ds.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private int data; 
	
	private boolean visited;
	
	public Node(int data){
		this.data = data;
		visited = false;
		links = new ArrayList<>();
	}
	
	private List<Node> links; 

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getLinks() {
		return links;
	}

	public void setLinks(List<Node> links) {
		this.links = links;
	}

	
	
	

}
