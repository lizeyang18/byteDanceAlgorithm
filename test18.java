package byteDance;

import java.util.HashMap;

/**
 * Created by lizeyang on 2020/5/13.
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 */
public class test18 {
    //时间复杂度O(n),就要牺牲空间复杂度了，使用HashMap
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!map.get(num)) {
                maxLen = Math.max(maxLen, getMaxLen(map, num));
            }
        }
        return maxLen;
    }

    //以当前数向前和向后依次判断
    public static int getMaxLen(HashMap<Integer, Boolean> map, int num) {
        if (map.containsKey(num) && !map.get(num)) {
            map.put(num, true);
            return 1 + getMaxLen(map, num - 1) + getMaxLen(map, num + 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 200, 3, 1, 100, 2, 99, 101, 5};
        System.out.println(test(nums));
    }
}
