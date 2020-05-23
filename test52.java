package byteDance;

import java.util.HashMap;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 15:57
 * function:柠檬水找零（leetcode 860）
 */
public class test52 {
    public static boolean lemonadeChange(int[] bills) {
        int bill5 = 0, bill10 = 0, bill20 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                bill5++;
            } else if (bill == 10) {
                if (bill5 >= 1) {
                    bill5--;
                } else {
                    return false;
                }
                bill10++;
            } else if (bill == 20) {
                if (bill10 >= 1 && bill5 >= 1) {
                    bill10--;
                    bill5--;
                } else if (bill5 >= 3) {
                    bill5 -= 3;
                } else {
                    return false;
                }
                bill20++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] bills = {5, 5, 5, 10, 20};
        int[] bills = {5};
        System.out.println(lemonadeChange(bills));
    }

}
