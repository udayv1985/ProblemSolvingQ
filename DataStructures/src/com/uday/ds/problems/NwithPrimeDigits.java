package com.uday.ds.problems;

public class NwithPrimeDigits {
	
	// k - number of prime digits
	public static int number(int n, int[] digits){
		//find digits
		int noCountWithDigits = 0;
		int d =1;
		int diff = 0;
		while(true){
			noCountWithDigits = (int) Math.pow(digits.length, d); 
			if(noCountWithDigits>=n){
				break;
			}
			diff = n - noCountWithDigits;
			d++;
		}
		// smallest d number
		int t = 0;
		for(int j = 1; j<=d; j++){
			t += Math.pow(10, d-j)*digits[0];
		}
		char[] number = new char[d];
		number = String.valueOf(t).toCharArray();
		int j = 0;
		int currentDigit = 1;
		while(diff>-1){
			number[d-currentDigit] = Character.forDigit(digits[j], 10);
			j++;
			if(j==digits.length){
				j=0;
				number[d-currentDigit] = Character.forDigit(digits[0], 10);
				currentDigit++;
			}
			diff--;
		}
		
		return Integer.valueOf(new String(number));
	}
	
	public static void main(String[] args){
		int[] digits = {2,3,5,7};
		System.out.println(number(10,digits));
	}

}
