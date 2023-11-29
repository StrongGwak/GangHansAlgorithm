#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    // 체력 설정
    int answer = health;
    int time = 0;
    // 공격 순서
    int attack = 0;
    // 연속 성공 카운트
    int success = 0;
    // 마지막 공격까지 반복
    while(time != attacks[attacks.size()-1][0]) {
        // 시간 증가
        time++;
        // 공격 시간인지 검사
        if(time == attacks[attack][0]) {
            // 체력 감소
            answer -= attacks[attack][1];
            // 다음 공격
            attack++;
            // 연속 성공 초기화
            success = 0;
            // 체력이 모두 닳았다면 -1 리턴
            if(answer <= 0) {
                return -1;
            }
        } else {
            // 연속 성공 증가
            success++;
            // 연속 성공 검사
            if(bandage[0] <= success) {
                // 기본 체력 회복과 추가 체력 회복
                answer += bandage[1] + bandage[2];
            } else {
                // 기본 체력 회복
                answer += bandage[1];
            }
            // 최대 체력을 넘었다면
            if(answer >= health) {
                // 최대 체력으로 고정
                answer = health;
            }
        }
    }
    return answer;
}