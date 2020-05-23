package byteDance;

/**
 * Created by lizeyang on 2020/5/13.
 * 快排 so easy~
 */
public class test14 {
    //递归实现，时间复杂度O(nlogn)，额外空间复杂度O(1),不稳定排序
    public static int[] test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, (int) (l + Math.random() * (r - l + 1)), r);
            int[] p = partition(nums, l, r);
            sort(nums, l, p[0] - 1);
            sort(nums, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, ++less, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 1, 8, 6, 0};
        int[] res = test(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
