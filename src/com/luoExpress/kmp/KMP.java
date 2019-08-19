package com.luoExpress.kmp;

public class KMP {
    public static int getIndexOf(String s,String m){
        if(s==null || m== null || m.length()<1  || s.length()<m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;//str1 pointer
        int i2 = 0;//str2 pointer
        int[] next = geNextArray(str2);
        while (i1<str1.length && i2<str2.length){
            if (str1[i1] == str2[i2]) {//匹配上了
                i1++;
                i2++;
            } else {//没匹配上

             if (next[i2] == -1) { //说明当前str2的指针在0位置，str1的字符没有和str2 的0位置上的匹配
                    i1++;//str1向前走一个
                } else {
                    i2 = next[i2];
                }
            }
        }

        return i2== str2.length?i1-i2:-1;//i2== str2.length说明str2被完全走过，在str1中一定存在str2
    }

    public static int[] geNextArray(char[] str2) {
        if (str2.length == 1) {
            return  new int[]{-1};
        }

        int [] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;

        int i = 2;
        int cn = 0;//跳到的位置
        while (i<next.length){
            if (str2[i-1] == str2[cn]) {
                next[i++] = ++cn;
            }else if(cn>0){//还可以继续往前跳
                cn = next[cn];//next数组的值就是跳的位置

            }else {
                next[i++] = 0;
            }
        }

        return next;
    }


    public static void main(String[] args) {
        String str = "abcabdababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str,match));
    }

}
