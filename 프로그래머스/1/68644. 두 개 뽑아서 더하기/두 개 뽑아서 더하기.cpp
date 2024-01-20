#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    int num[201] = {0};
    vector<int> answer;
    for (int i = 0; i < numbers.size()-1; i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            num[numbers[i] + numbers[j]]++;
        }
    }
    
    for (int i = 0 ; i < 201; i++) {
        if(num[i] > 0) {
            answer.push_back(i);
        }
    }
    return answer;
}