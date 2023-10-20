using System;

public class Solution {
    public int solution(int storey) {
        int answer = 0;
        int tmp = storey;
        int floor = 1;
        while (tmp != 0) {
            int check = tmp % 10;
            tmp /= 10;
            int nextCheck = tmp % 10;
            if(check == 5 && nextCheck > 4) {
                answer += 10 - check;
                tmp += 1;
            } else if (check > 5) {
                answer += 10 - check;
                tmp += 1;
            } else {
                answer += check;
            }
        }
        
        return answer;
    }
}