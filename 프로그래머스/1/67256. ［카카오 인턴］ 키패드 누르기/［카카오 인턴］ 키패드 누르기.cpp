#include <string>
#include <vector>
#include <stdlib.h>
#include <cmath>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int leftX = 1;
    int leftY = 4;
    int rightX = 1;
    int rightY = 4;
    for (int i = 0; i < numbers.size(); i++) {
        int num = 11;
        if (numbers[i] != 0) {
            num = numbers[i];
        }
        int move = ceil((float)num / 3);
        if (num % 3 == 1) {
            leftX = 1;
            leftY = move;
            answer += "L";
        } else if (num % 3 == 0) {
            rightX = 1;
            rightY = move;
            answer += "R";
        } else {
            int x = abs(move - leftY) + leftX;
            int y = abs(move - rightY) + rightX;
            cout << x << y << endl;
            if(x == y) {
                if (hand.compare("left") == 0) {
                    leftX = 0;
                    leftY = move;
                    answer += "L";
                } else {
                    rightX = 0;
                    rightY = move;
                    answer += "R";
                }
            } else if (x < y) {
                leftX = 0;
                leftY = move;
                answer += "L";
            } else {
                rightX = 0;
                rightY = move;
                answer += "R";
            }
        }
    }
    return answer;
}