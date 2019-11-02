package com.uday.dst.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeapSort {

    public static void heapSort(List<Integer> array){
        int n = array.size();
        for(int i = n/2-1; i>-1 ; i--){
           heapify(array,n,i);
        }
        int j = n -1;
        while(j>-1){
            swap(array,0,j);
            heapify(array,j,0);
            j--;
        }
    }

    private static void heapify(List<Integer> array, int n, int index){
        int l = 2*index +1;
        int r = 2*index + 2;
        int largest = index;
        if(l < n && array.get(l) > array.get(index)){
            largest = l;
        }
        if( r < n && array.get(r) > array.get(largest)){
            largest = r;
        }
        if(largest != index){
            swap(array,largest,index);
            heapify(array,n,largest);
        }
    }

    private static void swap(List<Integer> array, int a, int b){
        int temp = array.get(a);
        array.set(a,array.get(b));
        array.set(b,temp);
    }

    public static void main(String [] args){
        int arr[] = {8,4,1,6,7,3,2,8,9,5};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        heapSort(list);
        System.out.println(list);
    }
}
