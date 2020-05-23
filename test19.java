package byteDance;

/**
 * Created by lizeyang on 2020/5/13.
 * 接雨水:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class test19 {
    public static int test(int[] nums) {
        //时间复杂度O(n)
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int area = 0;
        int max = nums[0], maxIndex = 0;
        //找到最高处和下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        //从左边依次走到最高处，如果左边大于右边，可以接雨水
        int tmp = nums[0];
        for (int i = 1; i < maxIndex; i++) {
            if (nums[i] < tmp) {
                area += tmp - nums[i];
            } else {
                tmp = nums[i];
            }
        }
        //从右边依次走到最高处，如果右边大于左边，可以接雨水
        tmp = nums[nums.length - 1];
        for (int i = nums.length - 2; i > maxIndex; i--) {
            if (nums[i] > tmp) {
                tmp = nums[i];
            } else {
                area += tmp - nums[i];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(test(nums));
    }
}
