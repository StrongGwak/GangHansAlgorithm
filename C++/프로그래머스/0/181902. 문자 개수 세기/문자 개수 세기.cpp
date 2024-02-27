#include <string>
#include <vector>

using namespace std;

vector<int> solution(string my_string) {
    vector<int> answer;
    while (answer.size() < 52) {
        answer.push_back(0);
    }
    
    for (int i = 0; i < my_string.size(); i++) {
        if(my_string[i] <= 90) {
            int a = my_string[i] - 'A';
            answer[a]++;
        } else {
            int a = my_string[i] - 'a' + 26;
            answer[a]++;
        }
    }
    return answer;
}