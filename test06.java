package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 一个数据先递增再递减，找出数组不重复的个数
 */
public class test06 {
    //双指针法，每次取最小元素移动，不使用额外空间，O(n)
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        int count = 0;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                count++;
                l++;
            } else if (nums[l] > nums[r]) {
                count++;
                r--;
            } else {
                l++;
                r--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8, 9, 8, 6, 4, 3, 1,0};
        System.out.println(test(nums));
    }
}
