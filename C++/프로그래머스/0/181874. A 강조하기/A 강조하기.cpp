#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string myString) {
    string answer = "";
    for (int i = 0; i < myString.size(); i++) {
        if(myString[i] == 'a') {
            myString[i] -= 32;
        } else if(myString[i] <= 97 && myString[i] > 65) {
            myString[i] += 32;
        }
    }
    answer = myString;
    return answer;
}