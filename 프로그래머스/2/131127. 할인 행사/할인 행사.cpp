#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int check(vector<bool> end, int w) {
    for (int i = 0; i < end.size(); i++) {
        if (end[i]) {
            w--;
        }
    }
    if (w == 0) {
        return 1;
    }
    return 0;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    map<string, int> m;
    vector<bool> end;
    // 맵 필요한 물건, 개수 배열의 인덱스 연결
    // 충족 여부 벡터 초기화
    for (int i = 0; i < want.size(); i++) {
        m.insert({want[i], i + 1});
        end.push_back(false);
    }
    
    // 슬라이딩 윈도우를 위한 처음 작업
    for (int i = 0; i < 10; i++) {
        // 맵에 추가되지 않은 물품은 제외
        int d = m[discount[i]] - 1;
        if (d == -1) {
            continue;
        }
        // 필요 물품 감소
        number[d]--;
        // 필요 물품 충족되면 여부 체크
        if (number[d] == 0) {
            end[d] = true;
        } else {
            end[d] = false;
        }
    }
    
    // 회원 등록 가능한지 체크
    answer += check(end, end.size());
    
    for (int i = 10; i < discount.size(); i++) {
        int add = m[discount[i]] - 1;
        int sub = m[discount[i - 10]] - 1;
        
        // 이전 첫번째 물건을 빼줌
        if (sub != -1) {
            number[sub]++;
            if (number[sub] == 0) {
                end[sub] = true;
            } else {
                end[sub] = false;
            }
        }
        
        // 다음 물건 더해줌
        if (add == -1) {
            continue;
        } else {
            number[add]--;
            if (number[add] == 0) {
                end[add] = true;
            } else {
                end[add] = false;
            }
        }
        
        answer += check(end, end.size());
    }
    
    return answer;
}