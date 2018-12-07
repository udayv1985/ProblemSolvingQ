package com.uday.ds.graph;

public class IslandsProblem {
	
	int[][] matrix;
	
	int rows ;
	int cols ;
	
	public IslandsProblem(int m[][]){
		matrix = m;
		rows = matrix.length;
		cols = matrix[0].length;
	}
	
	public int islandCount(){
		int s = 0;
		
		boolean visited[][] = new boolean[rows][cols]; 
		for(int i =0;i<rows; i++){
			for(int j =0;j<cols;j++){
				if(matrix[i][j]==1 && !visited[i][j]){
					markNeighbours(i,j,visited);
					s+=1;
				}
			}
		}
		return s;
	}

	private void markNeighbours(int row, int col, boolean[][] visited) {
		visited[row][col] = true;
		for(int i=row-1;i<=row+1;i++){
			if(i<0 || i>=rows){
				continue;
			}
			for(int j=col-1;j<=col+1;j++){
				if(j<0 || j>=cols){
					continue;
				}
				if(matrix[i][j]==1 && !visited[i][j]){
					markNeighbours(i,j,visited);
				}
			}
		}
	}
	
	public static void main(String[] args){
		 int m[][]=  new int[][] {{1, 1, 0, 0, 0}, 
             {0, 1, 0, 0, 1}, 
             {1, 0, 0, 1, 1}, 
             {0, 0, 0, 0, 0}, 
             {1, 0, 1, 0, 1} 
            }; 
            IslandsProblem i = new IslandsProblem(m); 
            System.out.println("Number of islands is: "+ i.islandCount()); 
	}

}
