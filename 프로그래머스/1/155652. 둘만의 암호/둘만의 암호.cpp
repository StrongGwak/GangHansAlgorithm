#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    for (int i = 0; i < s.length(); i++) {
        char num = s[i];
        int a = 0;
        while(a < index) {
            num++;
            bool isClean;
            do {
                isClean = true;
                for(int j = 0; j < skip.length(); j++) {
                    if(num > 122) {
                        num = (num % 122) + 96;            
                    }
                    if(num == skip[j]) {
                        num++;
                        isClean = false;
                    }
                }
            } while(!isClean);
            
            a++;
        }
        answer += num;
    }
    return answer;
}