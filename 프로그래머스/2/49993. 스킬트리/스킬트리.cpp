#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    map<string, int> m;
    // 스킬트리 순서 정하기
    for (int i = 0; i < skill.size(); i++) {
        m.insert({skill.substr(i, 1), i + 1});
    }
    
    for (int i = 0; i < skill_trees.size(); i++) {
        // 현재 스킬트리 단계
        int tree = 1;
        bool flag = false;
        for (int j = 0; j < skill_trees[i].size(); j++) {
            string s = skill_trees[i].substr(j, 1);
            // 현재 단계보다 높은 단계를 배웠다면 불가능
            if (m[s] > tree) {
                flag = true;
                break;
            } else if (m[s] == tree) {
                // 같은 단계를 배웠다면 단계 증가
                tree++;
            }
        }
        if (!flag) {
            answer++;
        }
    }
    return answer;
}