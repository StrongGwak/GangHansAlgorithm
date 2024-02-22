#include <string>
#include <vector>
#include <sstream>
#include <map>

using namespace std;
vector<string> split(string str, char delimiter);

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
    
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
    
    return answer;
}

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    map<string, int> f;
    vector<vector<int>> gat;
    vector<int> score;
    
    for (int i = 0; i < friends.size(); i++) {
        f.insert({friends[i], i});
        score.push_back(0);
        vector<int> v;
        gat.push_back(v);
        for(int j = 0; j < friends.size(); j++) {
            gat[i].push_back(0);
        }
    }
    
    for (int i = 0; i < gifts.size(); i++) {
        vector<string> gift = split(gifts[i], ' ');
        int give = f[gift[0]];
        int take = f[gift[1]];
        gat[give][take]++;
        score[give]++;
        score[take]--;
    }
    
    for (int i = 0; i < gat.size(); i++) {
        int next = 0;
        for (int j = 0; j < gat[i].size(); j++) {
            if (gat[i][j] > gat[j][i]) {
                next++;
            } else if (gat[i][j] == gat[j][i]) {
                if(score[i] > score[j]){
                    next++;
                }
            }
        }
        if (answer < next) {
            answer = next;
        }
    }
    
    return answer;
}