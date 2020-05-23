package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * function:合并两个有序数组
 */
public class test03 {
    //解法1：归并数组，创建一个新数组然后merge，时间复杂度O(m+n)，空间复杂度O(m+n)
    public static int[] test(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2;
        } else if (nums2 == null) {
            return nums1;
        } else if (nums1 == null || nums2 == null) {
            return null;
        }
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                res[k++] = nums2[j++];
            } else {
                res[k++] = nums1[i++];
                res[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[k++] = nums2[j++];
        }
        return res;
    }

    //解法2:利用数组有序特点，从后开始比较，三指针，时间复杂度O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        //当len1结束时，将nums2数组元素拷贝到nums1中
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 5, 7, 9};
        int[] res = test(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
