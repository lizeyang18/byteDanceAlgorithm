package byteDance;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 16:14
 * function:圆圈剩下的数字 详解：https://blog.csdn.net/u011500062/article/details/72855826
 */
public class test53 {
    /**
     * 递推公式：f(n,m)= (f(n-1,m)+m)%n;f(n,m)表示n个数，每m时杀人，幸存者的下标结果
     * f(1,3) = 0;
     * f(2,3) = (f(1,3)+3)%2 = 1;
     * f(3,3) = (f(2,3)+3)%3 = 1;
     */


    public static int test(int n, int m) {
        //f(1,3) = 0;
        int f = 0;
        //从2开始
        for (int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        //因为返回数组下标，故+1
        return f + 1;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        System.out.println(test(n, m));
    }
}
