package byteDance;

/**
 * Created by lizeyang on 2020/5/16.
 * 一个有序数组，从随即一位截断，把前段放在后边，如 4 5 6 7 1 2 3求中位数
 */
public class test47 {
    //可以利用有序特点，用二分查找找到最大最小值，求中位数
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minNum = getMinNum(nums, 0, nums.length - 1);
        int maxNum = getMaxNum(nums, 0, nums.length - 1);
        System.out.println(minNum + " " + maxNum);
        return (minNum + maxNum) >> 1;
    }

    public static int getMinNum(int[] nums, int l, int r) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static int getMaxNum(int[] nums, int l, int r) {
        while (l < r - 2) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                l++;
            }
        }
        return nums[l] > nums[r] ? nums[l] : nums[r];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 10, 0, 1, 2, 3};
        System.out.println(test(nums));
    }
}
