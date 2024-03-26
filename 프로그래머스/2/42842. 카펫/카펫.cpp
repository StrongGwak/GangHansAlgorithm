#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    // 카펫의 크기는 격자의 합
    int total = brown + yellow;
    // 세로는 3이상이어야하니 가로도 3이상
    int x = 3;
    int y = 3;
    
    while (true) {
        // 가로는 세로보다 크거나 같고 
        // (가로 + 세로) * 2 - 4 == brown
        // 혹은 (가로 - 2) * (세로 - 2) == yellow
        if(x >= y && (x - 2) * (y - 2) == yellow) {
            answer.push_back(x);
            answer.push_back(y);
            return answer;
        }
        // 가로 세로 곱해서 총합이 나오면 가로 세로 값 설정
        x++;
        if(total % x == 0) {
            y = total / x;
        }
    }
    
    return answer;
}
