import java.util.Scanner;

public class Main{
    static int n, m, edge;
    static int[] chk, use, head, link, to;
    static long[] weight;

    static void addEdge(int u, int v, long w){
        link[edge] = head[u];
        to[edge] = v;
        weight[edge] = w;
        head[u] = edge++;
    }

    static boolean bfs(int pos){
        int[] que = new int[n];
        int front = 0, rear = 0;
        que[rear++] = 1; chk[1] = pos;
        while(front < rear){
            int v = que[front++];
            for(int idx=head[v]; idx!=-1; idx=link[idx]){
                int i = to[idx], e = idx / 2;
                long w = weight[idx];
                if(chk[i] == pos || use[e] == 1) continue;
                if((w >> pos & 1) != 0) continue;
                que[rear++] = i; chk[i] = pos;
            }
        }
        return chk[n] == pos;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        chk = new int[n+1];
        for(int i=1; i<=n; i++) chk[i] = -1;
        use = new int[m];
        head = new int[n+1];
        for(int i=1; i<=n; i++) head[i] = -1;
        link = new int[m*2];
        for(int i=0; i<m*2; i++) link[i] = -1;
        to = new int[m*2];
        weight = new long[m*2];

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            addEdge(u, v, w); addEdge(v, u, w);
        }

        long res = 0;
        for(int i=59; i>=0; i--){
            if(!bfs(i)) res |= ((long)1) << i;
            else for(int j=0; j<m; j++) if((weight[j*2] >> i & 1) != 0) use[j] = 1;
        }
        System.out.println(res);
    }
}