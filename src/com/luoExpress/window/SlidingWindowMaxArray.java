package com.luoExpress.window;

import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w<1||arr.length<w) {
            return null;

        }
        //LinkedList双向链表
        LinkedList<Integer> qmax = new LinkedList<>();//窗口内准备一个最大值的更新结构 保存的下标
        int[] res = new int[arr.length-w+1];//arr.length-w+1 生成最大值的个数
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty()&& arr[qmax.peekLast()]<=arr[i]){//双端链表尾部的值是否小于新加进来的
                    qmax.pollLast();//从尾部弹出
            }

            qmax.addLast(i);//把当前数 放在尾部
            //窗口没有形成之前，不会有任何一个下标弹出，如果过期了，从头部弹出一个下标
            if (qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            if (i >= w-1) {//窗口形成了
                res[index++] = arr[qmax.peekFirst()];//把当前的最大值收集到结果集里面
            }
        }

        return res;
    }
}
