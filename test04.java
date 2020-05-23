package byteDance;

/**
 * Created by lizeyang on 2020/5/12.
 * 剪绳子
 */
public class test04 {
    //不会溢出的情况,时间复杂度O(n*n/2)
    public static int test(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 3;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++){
            for(int j = 1;j<=i/2;j++){
                dp[i] = Math.max(dp[j]*dp[i-j],dp[i]);
            }
        }
        return dp[n];
    }

    //考虑溢出的情况,时间复杂度O(1)
    public static int test1(int n){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==2){
            return 3;
        }
        int res = 1;
        while(n>4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(test(n));
        System.out.println(test1(n));
    }
}
