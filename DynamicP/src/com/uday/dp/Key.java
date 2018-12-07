package com.uday.dp;

import java.util.Objects;


public class Key {
	int a;
	int b;
	
	public Key(int i, int j){
		a=i;
		b=j;
	}
	@Override
	public int hashCode() {
		return Objects.hash(a,b);
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return a +"," +b;
	}

}
