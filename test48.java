package byteDance;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lizeyang on 2020/5/16.
 * 一辆公交车，有m站，最多坐n人，输入一路上票的信息（即上车下车站），输出会不会超载
 */
public class test48 {
    public static boolean test(int[][] nums,int m,int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        //按照二维数组第一个元素排序
        Arrays.sort(nums,(v1, v2)->v1[0]-v2[0]);
        for(int i=0;i<nums.length;i++){
            for(int j = nums[i][0];j<=nums[i][1];j++){
                if(!map.containsKey(j)){
                    map.put(j,1);
                }else{
                    if(map.get(j)+1>n){
                        return false;
                    }
                    map.put(j,map.get(j)+1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] nums = {{1,5},{2,3},{2,4},{2,5},{4,5},{3,4},{1,2}};
        System.out.println(test(nums,m,n));
    }
}
