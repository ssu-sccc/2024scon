import java.util.Scanner;

public class Main{
    static int readTime(Scanner sc){
        String s = sc.next();
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        return h * 60 + m;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        int[] g = new int[20], c = new int[20], d = new int[20];
        int[] s = new int[20], e = new int[20];
        for(int i=0; i<n; i++){
            int sz = sc.nextInt();
            for(int j=0; j<sz; j++){
                g[cnt] = i;
                c[cnt] = sc.nextInt();
                d[cnt] = sc.nextInt();
                s[cnt] = d[cnt] * 1440 + readTime(sc);
                e[cnt] = d[cnt] * 1440 + readTime(sc);
                cnt++;
            }
        }

        int res = 0;
       for(int bit=0; bit<(1<<cnt); bit++){
           int sum = 0, mx = 0;
           boolean[] chk = new boolean[cnt];
           int[] use = new int[n];
           for(int i=0; i<cnt; i++) chk[i] = (bit >> i & 1) != 0;

           for(int i=0; i<cnt; i++) if(chk[i]) sum += c[i];
           for(int i=0; i<cnt; i++) if(chk[i]) use[g[i]]++;
           for(int i=0; i<n; i++) if(use[i] > mx) mx = use[i];
           if(sum != 22 || mx > 1) continue;

           boolean flag = true;
           for(int i=0; i<cnt; i++){
               if(!chk[i]) continue;
               for(int j=i+1; j<cnt; j++){
                   if(!chk[j]) continue;
                   boolean now = e[i] <= s[j] || e[j] <= s[i];
                   if(!now) flag = false;
               }
           }
           if(flag) res++;
       }
       System.out.println(res);
    }
}