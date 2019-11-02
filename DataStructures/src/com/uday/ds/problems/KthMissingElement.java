package com.uday.ds.problems;

public class KthMissingElement {

    public static int find(int[] a, int k){
        int prev = a[0];
        int count = 0;
        for(int i = 1; i < a.length; i++){
            int diff = a[i] - prev;
            if(a[i]!=prev && diff > 1){
                if( (diff-1) >= (k-count)){
                    return prev + k-count;
                }
                else{
                    count += (diff-1);
                }
            }
            prev = a[i];
        }
        return -1;
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 4, 4, 7, 8, 8, 13};
        System.out.println(find(arr,4));
    }
}
