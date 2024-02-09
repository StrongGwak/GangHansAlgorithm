#include <string>
#include <vector>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    unsigned long long num = stoull(p);
    for (int i = 0; i <= t.size() - p.size(); i++) {
        if(stoull(t.substr(i, p.size())) <= num){
            answer++;
        }
    }
    return answer;
}