package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 写一个函数，求平方根，函数参数为目标数字和精度
 */
public class test08 {
    //二分法，此题可简化为实现平方根只求整数;时间复杂度O(logn)
    public static double test(double target, double g) {
        double l = 1;
        double r = target;
        double mid;
        while (r - l > g) {
            mid = (l + r) / 2;
            if (mid * mid > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return (l+r)/2;
    }

    public static void main(String[] args) {
        double target = 4.1;
        double g = 0.001;
        System.out.println(test(target, g));
        System.out.println(Math.sqrt(4.1));
    }
}
