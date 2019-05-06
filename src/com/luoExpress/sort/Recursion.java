package com.luoExpress.sort;

/**
 * get max in an array
 */
public class Recursion {

    public static int getMax(int[] arr,int left,int right){

        if (left == right) {
            return  arr[left];
        }
        int mid = (left+right)/2;
        int maxLeft = getMax(arr,left,mid);
        int maxRight = getMax(arr,mid+1,right);
        return Math.max(maxLeft,maxRight);

    }

    public static void main(String[] args) {
        int[] arr = {4,3,9,1};
        System.out.println(getMax(arr,0,arr.length-1));
    }




}
