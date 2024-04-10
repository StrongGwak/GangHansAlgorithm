#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    stringstream ss(my_string);
    string tmp;
    while (getline(ss, tmp, ' ')) {
        if(tmp.compare("") != 0) {
            answer.push_back(tmp);
        }
    }
    return answer;
}