package com.uday.dp;

import java.util.Arrays;

/**
 * partition into two sub sets with minimum difference
 */
public class PartitionSetForMinSumDiff {

    public static int sumDiff(int[] a, int n, int sum) {
        int d = 0;
        if (n == 2) {
            d = Math.abs(a[0] - a[1]);
        } else {
            d = Math.min(
                    Math.abs(sumDiff(a, n - 1,sum-a[n-1]) - a[n - 1]), // just add last element to one of the sets
                    Math.abs(sum-2*a[n-1]));  // sole element in this set against all others
        }
        return d;
    }

    public static int partitionSumDiff(int[] a, int n, int sum1, int sum2) {
        int d = 0;
        if (n == 2) {
            d = Math.abs(a[0] - a[1]);
        } else {
            d = Math.abs(sumDiff(a, n - 1,0) - a[n - 1]);
        }
        return d;
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 6,34};
        int total = Arrays.stream(arr).sum();
        int n = arr.length;
        System.out.print("The minimum difference" +
                " between two sets is " +
                sumDiff(arr, n,total));
    }

}
