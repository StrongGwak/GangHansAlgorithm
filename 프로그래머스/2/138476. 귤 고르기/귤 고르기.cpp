#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

// 내림차순을 위한 비교
bool cmp(int a, int b) {
    return a > b;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    // 귤의 사이즈별 개수를 담을 벡터 
    vector<int> v1;
    // 최대 원소 수만큼 크기 할당
    v1.resize(10000001);
    // 사이즈별 개수 세기
    for (int i = 0; i < tangerine.size(); i++) {
        v1[tangerine[i]]++;
    }
    // 개수가 많은 순으로 정렬
    sort(v1.begin(), v1.end(), cmp);
    for (int i = 0; i < v1.size(); i++) {
        // 담는 순간 종류는 증가
        answer++;
        // 담고 나서 담을 귤의 개수가 남으면 다음 사이즈로 넘어감
        // 담을 수 없으면 종료
        if (k - v1[i] > 0) {
            // 담는 개수 빼주기
            k -= v1[i];
        } else {
            break;
        }
    }
    return answer;
}