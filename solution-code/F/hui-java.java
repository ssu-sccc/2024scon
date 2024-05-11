import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = 0, y = 0;
        int[] a = new int[n], b = new int[n];
        if(n % 3 == 2){ a[x++] = 1; b[y++] = 2; }
        for(int i=n%3+1; i<=n; i++){
            if(i % 3 != n % 3) a[x++] = i;
            else b[y++] = i;
        }

        System.out.println(x);
        for(int i=0; i<x; i++) System.out.print(a[i] + " ");
        System.out.println();

        System.out.println(y);
        for(int i=0; i<y; i++) System.out.print(b[i] + " ");
        System.out.println();
    }
}