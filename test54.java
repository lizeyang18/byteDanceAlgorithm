package byteDance;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:lizeyang
 * @Date:2020/5/23 16:33
 * function:给出一个数组nums，一个值k，找出数组中的两个下标 i，j 使得 nums[i] + nums[j] = k.
 */
public class test54 {
    //如果数组有重复元素，暴力解决，O(n2)
    //如果数组无重复元素，借助辅助空间HashMap,时间复杂度O(n)，额外空间复杂度O(n)
    public static List<int[]> test(int[] nums, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
            if (map.containsKey(k - nums[i])) {
                int[] res = new int[2];
                res[0] = i;
                res[1] = map.get(k - nums[i]);
                list.add(res);
                map.remove(nums[i]);
                map.remove(k - nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 3, 8, 2, 9};
        List<int[]> res = test(nums, 10);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
        }
    }
}
