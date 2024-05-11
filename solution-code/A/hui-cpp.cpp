#include <bits/stdc++.h>
using namespace std;

int N, M, A[101010], R;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> M;
    for(int i=1; i<=N; i++) cin >> A[i];
    for(int i=1; i<=N; i++) A[i] = max(0, A[i-1] + A[i]);
    for(int i=1; i<=N; i++) R += A[i] >= M;
    cout << R;
}