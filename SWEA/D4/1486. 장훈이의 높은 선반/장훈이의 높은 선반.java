import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, H, people[], min, c;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		T = parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = parseInt(st.nextToken());
			H = parseInt(st.nextToken());
			isSelected = new boolean[N];
			people = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				people[i] = parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			generateSubSet(0, H);
			sb.append('#').append(test_case).append(' ').append(min).append('\n');
		}
		System.out.println(sb);

	}

	public static void generateSubSet(int cnt, int sum) {
		if(sum <= 0) {
			if(min>Math.abs(sum)) {
				min = Math.abs(sum);
			}
			return;
		}
		if(cnt != N) {
			isSelected[cnt] = true;
			generateSubSet(cnt + 1, sum - people[cnt]);
			isSelected[cnt] = false;
			generateSubSet(cnt + 1, sum);
		}
		return;
	}
}