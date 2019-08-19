package manacher;

public class Manacher {

    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length()*2+1];
        int index = 0;
        for (int i = 0; i != res.length ; i++) {
            res[i]=(i&1)==0?'#':charArr[index++];//位运算  保证每隔一位放一个#
        }

        return res;
    }

    public static int maxLcpsLength(String str){
        if (str == null || str.length()==0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];//回文半径数组
        int C = -1;//对称中心
        int R = -1;//右边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {

            //R>i 区分最大的2种情况，i在R的内部或外部
            //2*C - i 就是对称点i'的位置，pArr[2*C - i]表示i'点的回文区域  R-i表示i到右边界R的距离
            pArr[i] = R>i?Math.min(pArr[2*C - i],R-i):1;
            //i+pArr[i]<charArr.length 要验证的区域没有越界， i-pArr[i]>-1 左边区域也没越界，情况2，3 我也让它向外扩充
            while (i+pArr[i]<charArr.length && i-pArr[i]>-1){
                if (charArr[i+pArr[i]]==charArr[i-pArr[i]]){////情况1，4，如果扩的结果相同，回文半径++
                    pArr[i]++;
                }else {
                    break;//而情况2，3肯定都扩不出去，所以直接让它停
                }
            }

            if (i+pArr[i]>R){//如果扩的边界超过R
                R=i+pArr[i];//就有了新的回文右边界了
                C = i;//新的回文中心
            }

            max = Math.max(max,pArr[i]);//记录最大的回文长度
        }

        return max-1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
