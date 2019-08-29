package com.luoExpress.sort;

public class Find {
    public static void main(String[] args) {
        int[] arrA = {2,3,4,5};
        int[] arrB = {10,2,3,11};
        find(arrA,arrB);
    }




    public static  void find(int[] arrA,int[] arrB){
        for (int i = 0; i < arrB.length; i++) {
            int j = 0;
            while (arrB[i]!= arrA[j]&& j<arrA.length-1){

                j++;
            }
            System.out.println(arrB[i]);

        }
    }

        public static boolean notEquals(int[] arrA,int num){
        for (int i = 0; i < arrA.length; i++) {
            if (num == arrA[i]) {
                return false;
            }
        }
        return true;

    }

}
