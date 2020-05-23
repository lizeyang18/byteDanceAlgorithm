package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 和为s 的连续正整数序列
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class test28 {
    //时间复杂度O(n)
    public static int[][] test(int target) {
        List<int[]> list = new ArrayList<>();
        int l = 1, r = 1;
        int index = 1;
        int count = 1;
        while (r < target) {
            if (count == target) {
                int[] nums = new int[r - l + 1];
                for (int i = 0; i < nums.length;i++) {
                    nums[i] = l+i;
                }
                list.add(nums);
                r = ++l;
                count = r;
            } else if (count < target) {
                r++;
                count += r;
            } else {
                count -= l++;
            }
        }
        int[][] nums = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int target = 15;
        int[][] res = test(target);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
