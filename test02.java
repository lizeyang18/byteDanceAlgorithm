package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * function:给定一个数组，可以向前走的最大距离
 */
public class test02 {
    //判断能否走到最后，O(n),O(1)
    public static boolean test(int[] nums){
        if(nums.length<=1){
            return true;
        }
        int maxLen = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<maxLen){
                maxLen = Math.max(maxLen,i+nums[i]);
            }
        }
        return maxLen>=nums.length-1;
    }
    //至少需要多少步走到最后,最好情况O(n)，最坏情况O(n2)
    public static int test2(int[] nums){
        if(nums.length<=1){
            return 0;
        }
        int maxLen = nums[0];
        int count = 1;
        int index = 1;
        while(index<nums.length-1){
            int tmp = maxLen;
           for(int i=index;i<=tmp;i++){
               maxLen = Math.max(maxLen,i+nums[i]);
           }
            if(maxLen!=tmp){
                count++;
            }
            index = maxLen;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(test(nums));
        int[] nums1 = {2,3,1,1,4};
        System.out.println(test2(nums1));
    }
}
