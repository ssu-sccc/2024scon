#include <bits/stdc++.h>
using namespace std;

char Check(string s){
    bool res = s[0] == 'T';
    for(int i=2; i<s.size(); i++){
        if(s[i-1] == '&') res = res & (s[i] == 'T');
        else res = res | (s[i] == 'T');
    }
    return res ? 'T' : 'F';
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int N; cin >> N;
    string S(N, '.');
    for(int i=0; i<N; i++) cin >> S[i];
    char C; cin >> C;
    if(Check(S) == C){ cout << 0; return 0; }

    auto flip = [&](int i){
        if(S[i] == 'T') S[i] = 'F';
        else if(S[i] == 'F') S[i] = 'T';
        else if(S[i] == '&') S[i] = '|';
        else S[i] = '&';
    };

    for(int i=0; i<N; i++){
        flip(i);
        if(Check(S) == C){ cout << 1; return 0; }
        flip(i);
    }
    cout << 2;

    if(C == 'T'){
        assert(S[N-2] == '&' && S[N-1] == 'F');
        S[N-2] = '|'; S[N-1] = 'T';
        assert(Check(S) == C);
    }
    else{
        assert(S[N-2] == '|' && S[N-1] == 'T');
        S[N-2] = '&'; S[N-1] = 'F';
        assert(Check(S) == C);
    }
}