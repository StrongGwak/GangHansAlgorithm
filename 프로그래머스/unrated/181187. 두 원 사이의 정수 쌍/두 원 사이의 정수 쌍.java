import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int i = 1; i <= r2; i++){
            long big =(long)(Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2))));
            long lSum = (long)(Math.pow(r1, 2) - Math.pow(i, 2));
            if (lSum < 0) {
                
            }
            long little = lSum < 0 ? 0 : (long)Math.ceil(Math.sqrt(lSum));
            
            answer += 1 + big -little;
            
        }
        answer *= 4;
        return answer;
    }
}