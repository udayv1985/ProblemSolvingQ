package com.uday.dp;

public class BooleanExpression {
	
	public static int count(char[] symb, char[] op, int n, boolean result){
		int r = 0;
		if(result){
			if(op[n-2]=='|' ){
				if(symb[n-1]=='F'){
					r = count(symb,op,n-1,true);
				}
				else{
					r = Math.max(count(symb,op,n-1,true),count(symb,op,n-1,false));
				}	
			}
			else if(op[n-2]=='&' ){
				if(symb[n-1]=='F'){
					r = 0;
				}
				else{
					r = count(symb,op,n-1,true);
				}	
			}
			else if(op[n-2]=='^' ){
				if(symb[n-1]=='F'){
					r = count(symb,op,n-1,true);
				}
				else{
					r = count(symb,op,n-1,false);
				}	
			}
		}
		
		return r;
	}
	
	private boolean computeOperator(char ch, char symb){
		boolean b_symb = getSymbol(symb);
		if(ch=='|'){
			return (true || b_symb);
		}
		else if(ch=='&'){
			return (true && b_symb);
		}
		else if(ch=='^'){
			return (true ^ b_symb);
		}
		
		return false;
	}
	
	private boolean getSymbol(char ch){
		if(ch=='T'){
			return true;
		}
		return false;
	}

}
