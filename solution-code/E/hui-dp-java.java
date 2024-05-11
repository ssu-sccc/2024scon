import java.util.Scanner;

public class Main{
    static int f(int x, int y, int op){
        if(op == 0) return x & y;
        else return x | y;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A = new int[1010][2];
        int[][] D = new int[1010][2];

        for(int i=1; i<=N; i++){
            char c = sc.next().charAt(0);
            A[i/2][i%2] = c == 'T' || c == '|' ? 1 : 0;
        }
        N /= 2;
        for(int i=0; i<1010; i++) for(int j=0; j<2; j++) D[i][j] = Integer.MAX_VALUE;
        
        D[0][A[0][1]] = 0;
        D[0][1-A[0][1]] = 1;
        for(int i=1; i<=N; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<2; k++){
                    for(int op=0; op<2; op++){
                        D[i][f(j, k, op)] = Math.min(D[i][f(j, k, op)], D[i-1][j] + (k != A[i][1] ? 1 : 0) + (op != A[i][0] ? 1 : 0));
                    }
                }
            }
        }

        char c = sc.next().charAt(0);
        System.out.println(D[N][c == 'T' ? 1 : 0]);
    }
}
