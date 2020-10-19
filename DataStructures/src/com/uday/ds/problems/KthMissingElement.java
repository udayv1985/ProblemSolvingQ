package com.uday.ds.problems;

/*
Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence. 
If no k-th missing element is there output -1. 
Examples : 

Input : a[] = {2, 3, 5, 9, 10};   
        k = 1;
Output : 4
Explanation: Missing Element in the increasing 
sequence are {4, 6, 7, 8}. So k-th missing element
is 4

Input : a[] = {2, 3, 5, 9, 10, 11, 12};       
        k = 4;
Output : 8
Explanation: missing element in the increasing 
sequence are {4, 6, 7, 8}  so k-th missing 
element is 8
*/

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
