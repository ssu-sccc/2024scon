#include <bits/stdc++.h>
using namespace std;

void Print(const vector<int> &v){
    cout << v.size() << "\n";
    copy(v.begin(), v.end(), ostream_iterator<int>(cout, " "));
    cout << "\n";
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int N; cin >> N;
    vector<int> A, B;
    if(N % 3 == 2) A.push_back(1), B.push_back(2);
    for(int i=N%3+1; i<=N; i++){
        if(i % 3 != N % 3) A.push_back(i);
        else B.push_back(i);
    }
    Print(A); Print(B);
}