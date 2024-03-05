#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr1, vector<int> arr2) {
    int answer = 0;
    if (arr1.size() > arr2.size()) {
        answer = 1;
    } else if (arr1.size() < arr2.size()) {
        answer = -1;
    } else {
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr1.size(); i++) {
            a += arr1[i];
            b += arr2[i];
        }
        if (a > b) {
            answer = 1;
        } else if (a < b) {
            answer = -1;
        } else {
            answer = 0;
        }
    }
    return answer;
}