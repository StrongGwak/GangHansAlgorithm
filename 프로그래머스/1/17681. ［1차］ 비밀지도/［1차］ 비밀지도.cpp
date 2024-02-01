#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for (int i = 0; i < arr1.size(); i++) {
        string line = "";
        for(int j = pow(2, n - 1); j >= 1; j = j / 2) {
            string map = " ";
            if(arr1[i] >= j) {
                arr1[i] -= j;
                map = "#";
            }
            if(arr2[i] >= j) {
                arr2[i] -= j;
                map = "#";
            }
            line += map;
        }
        answer.push_back(line);
    }
    return answer;
}