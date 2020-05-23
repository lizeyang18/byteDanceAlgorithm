package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 排序数组，平方后判断有多少不重复的数
 */
public class test05 {
    //前后指针，O(n)
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int tmp = Math.abs(nums[l]);
            if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                if (tmp != nums[l]) {
                    count++;
                    tmp = nums[l];
                }
                l++;
            } else {
                if (tmp != Math.abs(nums[r])) {
                    count++;
                    tmp = nums[r];
                }
                r--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -10, -5, 0, 1, 2, 5, 8, 10, 10, 10};
        System.out.println(test(nums));
    }
}
