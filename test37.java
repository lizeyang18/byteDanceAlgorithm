package byteDance;

/**
 * Created by lizeyang on 2020/5/15.
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class test37 {
    //题目要求了O(logn)，显然使用二分查找
    public static int[] test(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = getLeftNum(nums, 0, nums.length - 1, target);
        int right = getRightNum(nums, 0, nums.length - 1, target);
        if (left > -1 && right > -1) {
            res[0] = left;
            res[1] = right;
            return res;
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static int getLeftNum(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] != target || mid == 0) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int getRightNum(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid + 1] != target || mid == nums.length - 1) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = test(nums, 7);
        System.out.println(res[0] + " " + res[1]);
    }
}
