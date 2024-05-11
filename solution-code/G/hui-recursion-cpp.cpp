#include <bits/stdc++.h>
using namespace std;

int read_time(){
    string s; cin >> s;
    return stoi(s.substr(0, 2)) * 60 + stoi(s.substr(3, 2));
}

int N;
vector<array<int,3>> A[22], V;

bool Check(){
    int sum = 0;
    for(auto v : V) sum += v[0];
    if(sum != 22) return false;

    vector<array<int,2>> range;
    for(auto v : V) range.push_back({v[1], v[2]});
    sort(range.begin(), range.end());
    for(int i=1; i<range.size(); i++) if(range[i-1][1] > range[i][0]) return false;
    return true;
}

int Solve(int v){
    if(v == N) return Check();
    int res = Solve(v+1);
    for(auto a : A[v]){
        V.push_back(a); res += Solve(v+1); V.pop_back();
    }
    return res;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N;
    for(int i=0; i<N; i++){
        int sz; cin >> sz;
        for(int j=0; j<sz; j++){
            int c, d; cin >> c >> d;
            int s = d * 1440 + read_time();
            int e = d * 1440 + read_time();
            A[i].push_back({c, s, e});
        }
    }
    cout << Solve(0);
}