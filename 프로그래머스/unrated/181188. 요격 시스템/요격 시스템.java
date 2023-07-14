import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] targets) {
        int result = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });
        boolean[] destroy = new boolean[targets.length];
        for(int i = 0; i < targets.length; i++) {
            int last = 0;
            if(!destroy[i]){
                destroy[i] = true;
                last = targets[i][1];
                result += 1;
            } else {
                continue;
            }
            
            for(int j = i+1; j < targets.length; j++){
                if(last > targets[j][0]){
                    destroy[j] = true;
                    if(last > targets[j][1]){
                        last = targets[j][1];
                    }
                } else {
                    break;
                }
            }
        }
        
        return result;
    }
}