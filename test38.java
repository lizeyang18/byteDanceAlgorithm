package byteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 3sum:给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 */
public class test38 {
    public static List<List<Integer>> threeSum(int[] nums) {
        //三种循环必超时，先排序O(nlogn)，再用三指针O(n)
        List<List<Integer>> res = new ArrayList<>();
        sort(nums, 0, nums.length - 1);
        for(int i=0;i<nums.length;i++){
            if(nums[0]>0){
                return res;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int l = i+1,r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while(l<r&&nums[l+1]==nums[l]){
                        l++;
                    }
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }else{
                    r--;
                }
            }

        }
        return res;
    }

    public static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(nums, (int) (l + Math.random() * (r - l + 1)), r);
        int[] p = partition(nums, l, r);
        sort(nums, l, p[0] - 1);
        sort(nums, p[1] + 1, r);
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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
