import java.util.Scanner;

public class Main{
    static int n, cnt;
    static long tot;
    static int[] head, next, to;
    static long[] sz, dp, res;

    static void addEdge(int s, int e){
        int id = cnt++;
        next[id] = head[s]; to[id] = e; head[s] = id;
    }

    static void init(int v, int p){
        for(int i=head[v]; i!=-1; i=next[i]){
            int x = to[i]; if(x == p) continue;
            init(x, v); sz[v] += sz[x]; dp[v] += dp[x] + sz[x];
        }
    }

    static void solve(int v, int p, long up){
        res[v] = dp[v] + up;
        for(int i=head[v]; i!=-1; i=next[i]){
            int x = to[i]; if(x == p) continue;
            solve(x, v, up + dp[v]-dp[x]-sz[x] + tot-sz[x]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        head = new int[n+1];
        next = new int[2*n];
        to = new int[2*n];
        sz = new long[n+1];
        dp = new long[n+1];
        res = new long[n+1];
        for(int i=1; i<=n; i++) head[i] = -1;

        for(int i=1; i<n; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            addEdge(u, v); addEdge(v, u);
        }
        for(int i=1; i<=n; i++) sz[i] = sc.nextInt();
        for(int i=1; i<=n; i++) tot += sz[i];

        init(1, 0); solve(1, 0, 0);
        long mx = 0;
        for(int i=1; i<=n; i++) if(res[i] > mx) mx = res[i];
        System.out.println(mx);
        sc.close();
    }
}