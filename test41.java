package byteDance;

/**
 * Created by lizeyang on 2020/5/16.
 * 数组中第k大的数
 */
public class test41 {
    //利用快排或者归并排序，再取值即可
    public static int sort(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        if (k > nums.length || k < 0) {
            return 0;
        }
        return nums[k - 1];
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            partition(nums, l, mid, r);
        }
    }

    public static void partition(int[] nums, int l, int mid, int r) {
        int p = l;
        int q = mid + 1;
        int[] help = new int[r - l + 1];
        int index = 0;
        while (p <= mid && q <= r) {
            help[index++] = nums[p] < nums[q] ? nums[p++] : nums[q++];
        }
        while (p <= mid) {
            help[index++] = nums[p++];
        }
        while (q <= r) {
            help[index++] = nums[q++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 8, 4};
        System.out.println(sort(nums, 5));
    }
}
