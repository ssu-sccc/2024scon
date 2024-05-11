#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int N; cin >> N;
    for(int i=1; i<=N; i++){
        string s; cin >> s;
        int upper = count_if(s.begin(), s.end(), [](char c){ return isupper(c) != 0; });
        int lower = count_if(s.begin(), s.end(), [](char c){ return islower(c) != 0; });
        int digit = count_if(s.begin(), s.end(), [](char c){ return isdigit(c) != 0; });
        if(upper <= lower && s.size() <= 10 && digit < s.size()) cout << s;
    }
}