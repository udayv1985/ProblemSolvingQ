package com.uday.ds.graph;

import java.util.*;

public class Graph {
	
	private int numberOfVertices; 
	
	private List<Node> nodes;
	
	public Graph(int n){
		this.numberOfVertices = n;
		nodes = new LinkedList<>();
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	} 
	
	public List<Node> resetVisited(List<Node> nodes){
		for(Node n : nodes){
			n.setVisited(false);
		}
		return nodes;
	}
	
	public void addVertice(Node n){
		this.getNodes().add(n);
	}
	
	public void addEdge(Node a, Node b){
		Optional<Node> n = nodes.stream().filter(node-> node.equals(a)).
				findFirst();
		if(n.isPresent()){
			n.get().getLinks().add(b);
			
		}
		else{
			this.addVertice(a);
			addEdge(a,b);
		}
		
	}
	
	public void bfs(Node node){
		System.out.println("BFS of Graph - ");
		this.resetVisited(nodes);
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			Node n = q.poll();
			n.setVisited(true);
			System.out.print(n.getData()+", ");
			for(Node i : n.getLinks()){
				if(!i.isVisited()){
					q.add(i);
				}
			}
		}
		System.out.println();
	}
	
	public void dfs(Node node){
		System.out.println("DFS of Graph - ");
		this.resetVisited(nodes);
		dfsUtil(node);
		System.out.println();
	}
	
	private void dfsUtil(Node node){
		node.setVisited(true);
		System.out.print(node.getData()+", ");
		for(Node i : node.getLinks()){
			if(!i.isVisited()){
				dfsUtil(i);
			}
		}
	}
	
	public void topologicalSort(){
		System.out.println("Topological sort of Graph - ");
		this.resetVisited(nodes);
		Stack<Node> stack = new Stack<Node>();
		for(Node n : nodes){
			if(!n.isVisited()){
				topologicalSortUtil(n,stack);
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getData() + ", ");
		}
		System.out.println();
		
	}

	private void topologicalSortUtil(Node node, Stack<Node> stack) {
		node.setVisited(true);
		for(Node n : node.getLinks()){
			if(!n.isVisited()){
				topologicalSortUtil(n,stack);
			}
		}
		stack.push(node);
	}
	
	public static void main(String[] args){
		Node n1= new Node(1);
		Node n2= new Node(2);
		Node n3= new Node(3);
		Node n4= new Node(4);
		
		Graph g = new Graph(4);
		g.addEdge(n1, n2);
		g.addEdge(n1, n3);
		g.addEdge(n2, n3);
		g.addEdge(n2, n4);
		g.addEdge(n3, n1);
		g.addEdge(n3, n4);
		g.addEdge(n4, n4);
		
		//g.bfs(n3);
		//g.dfs(n3);
		//g.findPaths(n1, n4);
		//System.out.println(g.isCyclic());
		g.topologicalSort();
		
		// Create a graph given in the above diagram
        Graph g2 = new Graph(6);
        n1= new Node(1);
		n2= new Node(2);
		n3= new Node(3);
		n4= new Node(4);
		Node n5= new Node(5);
		Node n6= new Node(6);
        g2.addEdge(n6, n3);
        g2.addEdge(n6, n1);
        g2.addEdge(n5, n1);
        g2.addEdge(n5, n2);
        g2.addEdge(n3, n4);
        g2.addEdge(n4, n2);
        System.out.println(g2.isCyclic());
		//g2.topologicalSort();
		
	}
	
	public void findPaths(Node src, Node dest){
		List<List<Node>> paths = new ArrayList<>();
		//paths.get(0).add(src);
		List<Node> path = new ArrayList<>();
		findPath(src,dest,path);
		//path.forEach(n -> System.out.print(n.getData()+","));
		
	}
	
	private boolean findPath(Node node, Node dest, List<Node> path){
		if(node.isVisited()){
			return false;
		}
		node.setVisited(true);
		if(node.equals(dest)){
			path.forEach(n -> System.out.print(n.getData()+","));
			System.out.println();
			
		}
		boolean found = false;
		/*for(Node n : node.getLinks()){
			if(n.equals(dest)){
				path.add(node);
				path.add(n);
				return true;
			}
		}*/
		for(Node n : node.getLinks()){
			if(!n.isVisited()){
				path.add(node);
				found = findPath(n,dest,path);
				/*if(found){
					break;
				}
				else{
					path.remove(node);
				}*/
				path.remove(node);
			}
		}
		node.setVisited(false);
		return found;
	}
	
	public boolean isCyclic(){
		Set<Node> dfsTree = new HashSet<Node>();
		for(Node n : this.nodes){
			if(isCyclicUtil(n,dfsTree)){
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(Node n, Set<Node> dfsTree) {
		
		if(dfsTree.contains(n)){
			return true;
		}
		if(n.isVisited()){
			return false;
		}
		
		dfsTree.add(n);
		n.setVisited(true);
		
		for(Node c : n.getLinks()){
			if(isCyclicUtil(c,dfsTree)){
				return true;
			}
		}
		
		dfsTree.remove(n);
		
		return false; 
		
	}
	

}
