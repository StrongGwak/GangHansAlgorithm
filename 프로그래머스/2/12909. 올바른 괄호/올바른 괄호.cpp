#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<string> st;
    for (int i = 0; i < s.size(); i++) {
        string a = s.substr(i,1);
        if (a.compare("(") == 0) {
            st.push(a);
        } else {
            if(st.empty()) {
                return false;
            } else {
                st.pop();
            }
        }
    }
    if(!st.empty()) {
        return false;
    }
    
    return answer;
}