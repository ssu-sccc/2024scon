import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = 0, y = 0;
        for(int i=1; i<=n; i++){
            int t = sc.nextInt();
            if(t < 10) x = x * 10 + t;
            else x = x * 100 + t;
        }
        for(int i=1; i<=n; i++){
            int t = sc.nextInt();
            if(t < 10) y = y * 10 + t;
            else y = y * 100 + t;
        }
        System.out.println(x < y ? x : y);
    }
}