#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string input, char delimiter) {
	vector<string> answer;
	stringstream ss(input);
	string temp;

	while (getline(ss, temp, delimiter)) {
	    answer.push_back(temp);
	}

	return answer;
}

int solution(string binomial) {
    int answer = 0;
    vector<string> s = split(binomial, ' ');
    int a = stoi(s[0]);
    int b = stoi(s[2]);
    if (s[1].compare("+") == 0) {
        answer = a + b;
    } else if (s[1].compare("-") == 0) {
        answer = a - b;
    } else {
        answer = a * b;
    }
    return answer;
}