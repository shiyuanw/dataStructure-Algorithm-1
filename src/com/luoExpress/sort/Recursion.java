package com.luoExpress.sort;

public class Recursion {
    public static int getMax(int[] arr,int L,int R){
        if (L == R) {
           return arr[R];
        }

        int mid = (L+R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1,R);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {

        int[] arr = {11,22,3,4,9};
        System.out.println(getMax(arr,0,arr.length-1));

    }
}
