package com.uday.dst.sorting;

import java.util.Arrays;

public class MinHeapSort {

    public static void sort(int [] arr){
        int n = arr.length;
        for(int i = n/2-1; i > -1; i--){
            heapify(arr,n,i);
        }

        for(int i = n-1; i > -1; i--){
            BasicSortAlgos.swayArrayElements(arr,0,i);
            heapify(arr,i,0);
        }

        /*for(int i = 1; i < n; i++){
            heapify(arr,i,0);
        }
        */
    }

    public static void heapify(int[] arr, int n, int index){
        int l = 2*index +1;
        int r = 2*index +2;
        int smallest = index;
        if(l<n && arr[l]<arr[smallest]){
            smallest = l;
        }
        if(r<n && arr[r]<arr[smallest]){
            smallest = r;
        }
        if(smallest != index){
            BasicSortAlgos.swayArrayElements(arr,smallest,index);
            heapify(arr,n,smallest);
        }
    }

    public static void main(String[] args){
        int arr[] = {8,4,1,6,7,3,2,8,9,5};
        MinHeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
