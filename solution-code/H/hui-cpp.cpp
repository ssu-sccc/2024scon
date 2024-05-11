#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, K, A[1515151], D[1515151], Max[1515151];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> K;
    for(int i=N+1; i<=N+N; i++) cin >> A[i];
    partial_sum(A+1, A+N*3+1, A+1);
    for(int i=1; i<=N*3; i++){
        D[i] = D[i-1];
        if(i >= K) D[i] = max(D[i], Max[i-K] + A[i]);
        Max[i] = max(Max[i-1], D[i] - A[i]);
    }
    cout << D[N*3];
}