package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 买卖股票的最佳时机
 */
public class test01 {
    //一次买卖
    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                max = Math.max(nums[i] - min, max);
            }
        }
        return max;
    }

    //两次买卖
    public static int test1(int[] nums){
        if(nums==null||nums.length<=1){
            return 0;
        }
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for(int i=0;i<nums.length;i++){
            firstBuy = Math.max(firstBuy,-nums[i]);
            firstSell = Math.max(firstSell,nums[i] + firstBuy);
            secondBuy = Math.max(secondBuy,firstSell-nums[i]);
            secondSell = Math.max(secondSell,nums[i]+secondBuy);
        }
        return secondSell;
    }

    //不限次数买卖
    public static int test2(int[] nums){
        if(nums==null||nums.length<=1){
            return 0;
        }
        int buy = -nums[0];
        int sell = 0;
        for(int i=1;i<nums.length;i++){
            sell = Math.max(sell,buy+nums[i]);
            buy = Math.max(buy,sell-nums[i]);
        }
        return sell;
    }


    public static void main(String[] args) {
        int[] nums = {7, 6, 4, 3, 1};
//        System.out.println(test(nums));
        int[] nums1 = {1,2,3,4,5};
//        System.out.println(test1(nums1));
        int[] nums2 = {7,1,5,3,6,4};
        System.out.println(test2(nums2));
    }
}
