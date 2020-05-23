package byteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 递增数组，找出和为k的数对
 */
public class test31 {
    //双指针，时间复杂度O(n)
    public static int[][] test(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                int[] res = new int[2];
                res[0] = nums[l];
                res[1] = nums[r];
                list.add(res);
                l++;
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //升级：和为k的子数组，如nuns = {1,1,1},k=2;输出[1,1][1,1]
    //利用sum-k这样的查补方式找到map里面对应sum-k的value值
    public static int subArraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 8};
        int[][] res = test(nums, 9);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(subArraySum(nums, 6));
    }
}
