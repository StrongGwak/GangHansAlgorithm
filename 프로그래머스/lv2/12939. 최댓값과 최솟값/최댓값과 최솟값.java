class Solution {
    public String solution(String s) {
        String[] sn = s.split(" ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		String answer = "";
		for(int i = 0; i < sn.length; i++) {
			max = Math.max(Integer.parseInt(sn[i]), max);
			min = Math.min(Integer.parseInt(sn[i]), min);
		}
		answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}