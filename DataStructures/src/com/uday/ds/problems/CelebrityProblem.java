package com.uday.ds.problems;

import java.util.Arrays;
import java.util.Random;

public class CelebrityProblem {
	
	Person[] party; 
	
	public CelebrityProblem(int n){
		party = new Person[n];
		for(int i =0; i <party.length; i++){
			party[i] = new Person();
		}
		Random r = new Random();
		int celeb_index = r.nextInt(n-1);
		party[celeb_index].setCeleb();
		System.out.println("celeb is at :"+ celeb_index);
	}
	
	
	class Person{
		
		private String name = "Citizen";
		public Person(){
			//isCeleb = true;
		}
		public void setCeleb(){
			name = "Star";
		}
		
		public boolean knows(Person b){
			if(this.name.equals("Star")){
				return false;
			}
			if(b.name.equals("Star")){
				return true;
			}
			else{
				Random r = new Random();
				if(r.nextInt(100)%2==0){
					return true;
				}
			}
			return false;
		}
	}
	
	public int findCelebrity(){
		int i,j;
		for(i = 0,j=party.length-1; j>-1 && i<party.length-1 && i!=j;){
			boolean iknowsJ = party[i].knows(party[j]);
			boolean jKnowsI = party[j].knows(party[i]);
			if(iknowsJ && !jKnowsI){
				i++;
			}
			else if(!iknowsJ && jKnowsI){
				j--;
			}
			else{
				i++;
				j--;
			}
		}
		System.out.println(i+","+j);
		return j;
	}
	
	public static void main(String[] args){
		CelebrityProblem p = new CelebrityProblem(10);
		System.out.println("celeb found at : "+p.findCelebrity());
		//Arrays.asList(p.party).stream().forEach(a->System.out.println(a.name));
	}
}
