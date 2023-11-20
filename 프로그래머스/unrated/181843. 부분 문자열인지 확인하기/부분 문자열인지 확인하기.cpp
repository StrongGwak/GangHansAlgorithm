#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string target) {
    int answer = 0;
    int nPos = my_string.find(target);
    if( nPos != string::npos ) { // 찾고자 하는 문자열이 있었는지 검사
	    answer = 1;
    }
    return answer;
}