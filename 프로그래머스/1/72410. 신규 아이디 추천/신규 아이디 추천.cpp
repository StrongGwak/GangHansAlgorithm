#include <string>
#include <vector>
#include <regex>

using namespace std;

string solution(string new_id) {
    string answer = "";
    for (int i = 0; i < new_id.length(); i++) {
        if(new_id[i] >= 65 && new_id[i] <= 90) {
            new_id[i] += 32;
        }
    }
    new_id = regex_replace( new_id , regex("[^a-z0-9-_.]+"), "" );
    for (int i = new_id.length() - 1; i >= 0; i--) {
        if(new_id[i] == 46 && new_id[i] == new_id[i-1]) {
            new_id.erase(new_id.begin() + i-1, new_id.begin() + i);
        }
    } 
    if (new_id[0] == 46) {
        new_id.erase(new_id.begin());
    }
    if (new_id[new_id.length() - 1] == 46) {
        new_id.erase(new_id.end()-1);
    }
    if (new_id.empty()) {
        new_id = "a";
    }
    if (new_id.length() > 15) {
        new_id.erase(new_id.begin() + 15, new_id.end());
        if (new_id[new_id.length() - 1] == 46) {
            new_id.erase(new_id.end()-1);
        }
    }
    
    while (new_id.length() <= 2) {
        new_id += new_id[new_id.length()-1];
    }
    answer = new_id;
    
    return answer;
}