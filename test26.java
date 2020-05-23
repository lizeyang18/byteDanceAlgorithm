package byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lizeyang on 2020/5/15.
 * 合并区间
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 */
public class test26 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1, v2)->v1[0]-v2[0]);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while(i<intervals.length){
            List<Integer> list = new ArrayList<>();
            int tmp = intervals[i][1];
            list.add(intervals[i][0]);
            while(i+1<intervals.length&&tmp>=intervals[i+1][0]){
                tmp = intervals[i+1][1]>tmp?intervals[i+1][1]:tmp;
                i++;
            }
            list.add(tmp);
            res.add(list);
            i++;
        }
        int[][] nums = new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            nums[j][0] = res.get(j).get(0);
            nums[j][1] = res.get(j).get(1);
        }
        return nums;
    }
}
