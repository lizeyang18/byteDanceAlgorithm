package byteDance;

/**
 * Created by lizeyang on 2020/5/15.
 * 归并排序,so easy~
 */
public class test29 {
    //时间复杂度O(nlogn)，稳定
    public static int[] sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        partition(nums, l, mid, r);
    }

    public static void partition(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p = l;
        int q = mid + 1;
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
            nums[l + i] = help[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 2, 8, 5};
        int[] res = sort(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}