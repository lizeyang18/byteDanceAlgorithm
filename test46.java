package byteDance;

import java.util.HashMap;

/**
 * Created by lizeyang on 2020/5/16.
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class test46 {
    //时间复杂度O(n)，额外空间复杂度O(n)
    public static int test(String s){
        if(s==null||s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0,maxLen = 0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s= "pwwkew";
        System.out.println(test(s));
    }
}
