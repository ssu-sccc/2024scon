#include <bits/stdc++.h>
using namespace std;

int N, A[1010][2], D[1010][2];

int f(int x, int y, int op){
    if(op == 0) return x & y;
    else return x | y;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int N; cin >> N;
    for(int i=1; i<=N; i++){
        char c; cin >> c;
        A[i/2][i%2] = c == 'T' || c == '|';
    }
    N /= 2;

    memset(D, 0x3f, sizeof D);
    D[0][A[0][1]] = 0;
    D[0][!A[0][1]] = 1;
    for(int i=1; i<=N; i++){
        for(int j=0; j<2; j++){
            for(int k=0; k<2; k++){
                for(int op=0; op<2; op++){
                    D[i][f(j,k,op)] = min(D[i][f(j,k,op)], D[i-1][j] + (k != A[i][1]) + (op != A[i][0]));
                }
            }
        }
    }

    char c; cin >> c;
    cout << D[N][c=='T'];
}