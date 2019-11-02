package com.uday.ds.problems;

public class FirstLastElm {

    public static int find(int[] a, int d, boolean first) {
        int l = 0;
        int h = a.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (a[m] == d && (m==0 || !first || a[m] > a[m - 1]) && (m==a.length-1 || first || a[m] < a[m + 1])) {
                return m;
            } else if (a[m] <= d) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        System.out.println(find(arr,2,true));
    }
}
