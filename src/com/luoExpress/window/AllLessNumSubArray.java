package com.luoExpress.window;

import java.util.LinkedList;

public class AllLessNumSubArray {


    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length==0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();//最小值更新结构
        LinkedList<Integer> qmax = new LinkedList<>();//最大值更新结构
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length){//L固定，R向右移动，扩到不能再扩，停下来
            while (R < arr.length){
                //最小值结构更新
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]){
                    qmin.pollLast();
                }
                qmin.addLast(R);
                //最大值结构更新
                while(!qmax.isEmpty() && arr[qmax.peekLast()]<= arr[R]){
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {//不达标
                    break;

                }
                R++;
            }
            //最小值结构下标是否过期
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            //最大值结构下标是否过期
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }

            res += R-L;//得到所有以L开头的子数组的数量
            L++;//让L向右移动一个位置
        }

        return res;
    }


    public static void main(String[] args) {

    }
}
