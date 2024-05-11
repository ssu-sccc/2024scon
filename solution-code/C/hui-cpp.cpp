#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    ll N, X=0, Y=0; cin >> N;
    for(int i=1; i<=N; i++){
        int t; cin >> t;
        if(t < 10) X = X * 10 + t;
        else X = X * 100 + t;
    }
    for(int i=1; i<=N; i++){
        int t; cin >> t;
        if(t < 10) Y = Y * 10 + t;
        else Y = Y * 100 + t;
    }
    cout << min(X, Y);
}