#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string a, string b) {
    string answer = "";
    vector<int> tmp;
    int l = 0;
    int next = 0;
    int al = a.size() - 1;
    int bl = b.size() - 1;
    if (a.size() > b.size()) {
        l = a.size() - 1;
    } else {
        l = b.size() - 1;
    }
    while (l >= 0) {
        int sum = next;
        if(al >= 0) {
            sum += a[al--] - '0';
        }
        if(bl >= 0) {
            sum += b[bl--] - '0';
        }
        
        if (sum >= 10) {
            tmp.push_back(sum % 10);
            next = 1;
        } else {
            tmp.push_back(sum);
            next = 0;
        }
        l--;
    }
    
    if (next == 1) {
        tmp.push_back(next);
    }
    
    for (int i = tmp.size() - 1; i >= 0; i--) {  
        answer += to_string(tmp[i]);
    }
    return answer;
}