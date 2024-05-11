#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int N, M, C[303030], U[303030];
ll W[303030], R;
vector<pair<int,int>> G[303030];

void DFS(int v, int pos){
    C[v] = pos;
    for(auto [i,e] : G[v]){
        if(C[i] == pos || U[e]) continue;
        if(W[e] >> pos & 1) continue;
        DFS(i, pos);
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> M;
    for(int i=1; i<=M; i++){
        int u, v; cin >> u >> v >> W[i];
        G[u].emplace_back(v, i);
        G[v].emplace_back(u, i);
    }
    memset(C, -1, sizeof C);
    for(int i=59; i>=0; i--){
        DFS(1, i);
        if(C[N] != i) R |= 1LL << i;
        else for(int j=1; j<=M; j++) if(W[j] >> i & 1) U[j] = 1;
    }
    cout << R;
}