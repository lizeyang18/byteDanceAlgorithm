package byteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 无序数组，从小到大找到第一个缺的数，比如[8 2 4 3 6 9 7 11 12],第一个缺的就是5
 */
public class test34 {
    //时间复杂度O(n)，额外空间复杂度O(n)
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            list.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(min)) {
                min++;
            } else {
                return min;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 3, 6, 9, 7, 11, 12};
        System.out.println(test(nums));
    }
}
