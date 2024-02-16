#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int N;

bool comp(string a, string b){
	if(a[N] == b[N]){
        return a < b;
    }
    else{
        return a[N] < b[N];
    }
}

vector<string> solution(vector<string> strings, int n) {
    N = n;
    vector<string> answer;
    sort(strings.begin(), strings.end(), comp);
    for (int i = 0; i < strings.size(); i++) {
        answer.push_back(strings[i]);
    }
    return answer;
}