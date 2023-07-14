class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int first = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < sequence.length; i++){
            sum += sequence[i];
            while(sum > k) {
                sum -= sequence[first];
                first++;
            } 
            if((i-first) < length && sum == k){
                answer[0] = first;
                answer[1] = i;
                length = i - first;
            }
        }
        
        return answer;
    }
}