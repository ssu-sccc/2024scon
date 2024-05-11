#include <bits/stdc++.h>
using namespace std;

int read_time(){
    string s; cin >> s;
    return stoi(s.substr(0, 2)) * 60 + stoi(s.substr(3, 2));
}

int N, U[22], R;
vector<array<int,4>> A, V;

bool Check(){
    memset(U, 0, sizeof U);
    for(auto v : V) if(U[v[0]]++) return false;

    int sum = 0;
    for(auto v : V) sum += v[1];
    if(sum != 22) return false;

    vector<array<int,2>> range;
    for(auto v : V) range.push_back({v[2], v[3]});
    sort(range.begin(), range.end());
    for(int i=1; i<range.size(); i++) if(range[i-1][1] > range[i][0]) return false;
    return true;
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
            A.push_back({i, c, s, e});
        }
    }
    for(int bit=0; bit<(1<<A.size()); bit++){
        V.clear();
        for(int i=0; i<A.size(); i++) if(bit >> i & 1) V.push_back(A[i]);
        R += Check();
    }
    cout << R;
}