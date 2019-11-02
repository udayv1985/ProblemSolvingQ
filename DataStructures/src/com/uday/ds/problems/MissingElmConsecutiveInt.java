package com.uday.ds.problems;

public class MissingElmConsecutiveInt {

    public static int find(int[] arr){
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int m = (h+l)/2;

            if(arr[m]-m == arr[l]){
                if(arr[m+1]-arr[m]>1){
                    return arr[m]+1;
                }
                l=m+1;
            }
            else if(arr[m]-m > arr[l]){
                if(arr[m]-arr[m-1]>1){
                    return arr[m]-1;
                }
                h=m-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(find(arr));
    }

}
