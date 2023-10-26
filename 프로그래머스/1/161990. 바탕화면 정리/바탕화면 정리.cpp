#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int maxX = 0;
    int maxY = 0;
    int minX = wallpaper.size();
    int minY = wallpaper[0].length();
    for(int i = 0; i < wallpaper.size(); i++) {
        for(int j = 0; j < wallpaper[i].length(); j++) {
            if(wallpaper[i].at(j) == '#') {
                if(maxX < i+1) {
                    maxX = i + 1;
                }
                if(maxY < j+1) {
                    maxY = j + 1;
                }
                if(minX > i) {
                    minX = i;
                }
                if(minY > j) {
                    minY = j;
                }
            }
        }
        
    }
    answer.push_back(minX);
    answer.push_back(minY);
    answer.push_back(maxX);
    answer.push_back(maxY);
    return answer;
}