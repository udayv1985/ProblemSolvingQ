package com.uday.ds.problems;

public class LastDuplicateInSorted {

    public static int find(int[] a){
        int prev = a[a.length-1];
        for(int i =a.length-2; i>-1; i--){
            if(a[i]==prev){
                return i+1;
            }
            prev = a[i];
        }
        return -1;
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 4, 4, 7, 8, 8, 13};
        System.out.println(arr[find(arr)]);
    }
}
