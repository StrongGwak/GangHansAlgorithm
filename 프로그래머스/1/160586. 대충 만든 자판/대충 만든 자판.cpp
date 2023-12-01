#include <string>
#include <vector>
#include <map> 

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    // 맵으로 같은 알파벳이어도 가장 빠른 순서로 매핑
    map<char, int> keyIndex;
    for (int i = 0; i < keymap.size(); i++) {
        string keys = keymap[i];
        for (int j = 0; j < keys.length(); j++) {
            char key = keys[j];
            int index = j + 1;
            if(keyIndex.find(key) == keyIndex.end()){
                keyIndex.insert({key, index});
            } else {
                if(keyIndex[key] > index) {
                    keyIndex[key] = index;
                }             
            }
            
        }
    }
    for (int i = 0; i < targets.size(); i++) {
        answer.push_back(0);
        string target = targets[i];
        for (int j = 0; j < target.size(); j++) {
            char key = target[j];
            if(keyIndex[key] == 0) {
                answer.back() = -1;
                break;
            }
            answer.back() += keyIndex[key];
        }
    }
    return answer;
}