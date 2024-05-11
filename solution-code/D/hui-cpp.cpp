#include <bits/stdc++.h>
using namespace std;

void Solve(){
    int n, s, e; cin >> n >> s >> e;
    if(abs(s-e) + 1 == n) cout << 0 << "\n";
    else if(s == 1 || s == n || abs(s-e) == 1) cout << 1 << "\n";
    else cout << 2 << "\n";
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int TC; cin >> TC;
    for(int tc=1; tc<=TC; tc++) Solve();
}