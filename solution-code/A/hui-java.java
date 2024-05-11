import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), res = 0;
        int[] a = new int[n+1];
        for(int i=1; i<=n; i++) a[i] = sc.nextInt();
        for(int i=1; i<=n; i++){
            if(a[i-1] + a[i] > 0) a[i] += a[i-1];
            else a[i] = 0;
        }
        for(int i=1; i<=n; i++) if(a[i] >= m) res++;
        System.out.println(res);
        sc.close();
    }
}