#include <string>
#include <vector>
#include <map>
#include <sstream>

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

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    vector<string> todays = split(today, '.');
    map<string, int> tmap;
    
    for (int i = 0; i < terms.size(); i++) {
        vector<string> result = split(terms[i], ' ');
        tmap.insert({result[0], stoi(result[1])});
    }
    
    for (int i = 0; i < privacies.size(); i++) {
        int year = stoi(todays[0]) - stoi(privacies[i].substr(0, 4));
        int month = stoi(todays[1]) - stoi(privacies[i].substr(5, 2)) + (year * 12);
        int day = stoi(privacies[i].substr(8, 2));
        string t = privacies[i].substr(privacies[i].size() - 1, 1);
        int termMonth = tmap[t];
        
        if(month > termMonth) {
            answer.push_back(i + 1);
        } else if (month == termMonth && day <= stoi(todays[2])) {
            answer.push_back(i + 1);
        } else {
            continue;
        }
    }
    
    return answer;
}