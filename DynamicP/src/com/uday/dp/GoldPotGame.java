package com.uday.dp;

import java.util.Arrays;

public class GoldPotGame {

    private static int optimize(int[] a, int i, int j, int sum) {

        if (j == i + 1) {
            return Math.max(a[i], a[j]);
        }

        return Math.max(sum - optimize(a, i + 1, j, sum - a[i]), sum - optimize(a, i, j - 1, sum - a[j]));

    }

    public static int maxVal(int[] a){
        return optimize(a,0,a.length-1, Arrays.stream(a).sum());
    }

    public static void main(String[] args){
        int arr[] =  {20, 30, 2, 2, 2, 10 };
        System.out.println(maxVal(arr));
        System.out.println(optimizeByMin(arr,0,arr.length-1));
    }



    public static int optimizeByMin(int[] a, int i, int j){
        if (j == i + 1) {
            return Math.max(a[i], a[j]);
        }
        int first = a[i] + Math.min(optimizeByMin(a,i+2,j),optimizeByMin(a,i+1,j-1));
        int second = a[j] + Math.min(optimizeByMin(a,i,j-2),optimizeByMin(a,i+1,j-1));
        return Math.max(first,second);
    }
}
