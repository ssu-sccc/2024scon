#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int N, M, P[303030], U[303030], V[303030];
ll W[303030], R;
bool C[303030];

int Find(int v){ return v == P[v] ? v : P[v] = Find(P[v]); }
void Merge(int u, int v){ P[Find(u)] = Find(v); }

bool Check(int pos){
    iota(P+1, P+N+1, 1);
    for(int i=1; i<=M; i++){
        if(C[i]) continue;
        if(~W[i] >> pos & 1) Merge(U[i], V[i]);
    }
    return Find(1) == Find(N);
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> M;
    for(int i=1; i<=M; i++) cin >> U[i] >> V[i] >> W[i];
    for(int i=59; i>=0; i--){
        if(!Check(i)) R |= 1LL << i;
        else for(int j=1; j<=M; j++) if(W[j] >> i & 1) C[j] = 1;
    }
    cout << R;
}