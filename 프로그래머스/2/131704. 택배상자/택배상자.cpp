#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    int o = 0;
    stack<int> main;
    stack<int> sub;
    for (int i = order.size(); i >= 1; i--) {
        main.push(i);
    }
    
    while (!main.empty() || !sub.empty()) {
        bool flag = false;
        if(!main.empty() && o < order.size() 
           && main.top() == order[o]) {
            main.pop();
            answer++;
            o++;
            flag = true;
        }
        if(!sub.empty() && o < order.size() 
           && sub.top() == order[o]) {
            sub.pop();
            answer++;
            o++;
            flag = true;
        }
        if (!main.empty() && !flag) {
            sub.push(main.top());
            main.pop();
        } else if (main.empty() && !flag) {
            break;
        }
        
    }
    return answer;
}