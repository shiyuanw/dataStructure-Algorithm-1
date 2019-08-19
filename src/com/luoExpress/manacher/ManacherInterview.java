package com.luoExpress.manacher;

public class ManacherInterview {
    public static char[] manacherString(String str){

        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for (int i = 0; i != res.length ; i++) {
            res[i]=(i&1)==0?'#':charArr[index++];//位运算  保证每隔一位放一个#
        }

        return res;
    }

    public static String shortestAdd(String str){
        if (str == null || str.length()==0) {
            return null;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];//回文半径数组
        int index = -1;//对称中心
        int pR = -1;//右边界
        int maxContainsEnd = -1;
        for (int i = 0; i < charArr.length; i++) {

            //R>i 区分最大的2种情况，i在R的内部或外部
            //2*C - i 就是对称点i'的位置，pArr[2*C - i]表示i'点的回文区域  R-i表示i到右边界R的距离
            pArr[i] = pR>i?Math.min(pArr[2*index - i],pR-i):1;
            //i+pArr[i]<charArr.length 要验证的区域没有越界， i-pArr[i]>-1 左边区域也没越界，情况2，3 我也让它向外扩充
            while (i+pArr[i]<charArr.length && i-pArr[i]>-1){
                if (charArr[i+pArr[i]]==charArr[i-pArr[i]]){////情况1，4，如果扩的结果相同，回文半径++
                    pArr[i]++;
                }else {
                    break;//而情况2，3肯定都扩不出去，所以直接让它停
                }
            }

            if (i+pArr[i]>pR){//如果扩的边界超过R
                pR=i+pArr[i];//就有了新的回文右边界了
                index = i;//新的回文中心
            }

            if (pR == charArr.length) {//当整体的回文来到最右边界的时候
                maxContainsEnd = pArr[i];
                break;
            }

        }

        char[] res = new char[str.length()-maxContainsEnd+1];
        for (int i = 0; i < res.length; i++) {
            res[res.length-1-i] = charArr[i*2+1];
        }

        return String.valueOf(res);


    }

    public static void main(String[] args) {
        String s = "abcd12321";
        System.out.println(shortestAdd(s));
    }


}
