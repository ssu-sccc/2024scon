import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[] a = new long[n*3+1];
        long[] dp = new long[n*3+1];
        long[] mx = new long[n*3+1];
        for(int i=n+1; i<=n+n; i++) a[i] = sc.nextInt();
        for(int i=1; i<=n*3; i++) a[i] += a[i-1];
        for(int i=1; i<=n*3; i++){
            dp[i] = dp[i-1];
            if(i >= k){
                long tmp = mx[i-k] + a[i];
                if(tmp > dp[i]) dp[i] = tmp;
            }
            mx[i] = mx[i-1] > dp[i] - a[i] ? mx[i-1] : dp[i] - a[i];
        }
        System.out.println(dp[n*3]);
        sc.close();
    }
}