import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=1; tc<=t; tc++){
            int n = sc.nextInt(), s = sc.nextInt(), e = sc.nextInt();
            int ans = 2;
            if(s == 1 && e == n || e == 1 && s == n) ans = 0;
            else if(s == 1 || s == n || s + 1 == e || s - 1 == e) ans = 1;
            System.out.println(ans);
        }
        sc.close();
    }
}