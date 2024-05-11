#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, T, S[202020], D[202020], R[202020];
vector<int> G[202020];

void Init(int v, int b=-1){
    for(auto i : G[v]) if(i != b) Init(i, v), S[v] += S[i], D[v] += D[i] + S[i];
}

void Solve(int v, int b=-1, ll up=0){
    R[v] = D[v] + up;
    for(auto i : G[v]) if(i != b) Solve(i, v, up + D[v]-D[i]-S[i] + T-S[i]);
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N;
    for(int i=1,u,v; i<N; i++) cin >> u >> v, G[u].push_back(v), G[v].push_back(u);
    for(int i=1; i<=N; i++) cin >> S[i];
    Init(1); T = S[1]; Solve(1);
    cout << *max_element(R+1, R+N+1);
}