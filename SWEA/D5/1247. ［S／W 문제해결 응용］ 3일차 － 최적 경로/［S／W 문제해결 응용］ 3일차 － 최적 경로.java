import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, min, x, sum, num[][], c[], h[], value[][];
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// t 테스트케이스
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			// n 고객의 수
			n = Integer.parseInt(br.readLine());
			// 방문 여부
			isVisited = new boolean[n];
			st = new StringTokenizer(br.readLine(), " ");
			// 회사 좌표
			c = new int[2];
			c[0] = Integer.parseInt(st.nextToken());
			c[1] = Integer.parseInt(st.nextToken());
			// 집 좌표
			h = new int[2];
			h[0] = Integer.parseInt(st.nextToken());
			h[1] = Integer.parseInt(st.nextToken());
			num = new int[n][2];
			// 고객의 좌표
			for(int i = 0; i < n; i++) {
				num[i][0] = Integer.parseInt(st.nextToken());
				num[i][1] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			value = new int[n][2];
			check(0);
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void check(int cnt) {
		if(cnt == n) {
			// 회사에서 첫 고객과의 거리
			sum = Math.abs(c[0] - value[0][0]) + Math.abs(c[1] - value[0][1]);
			// 고객과 고객의 거리
			for(int i = 0; i < value.length-1; i++) {
				sum += Math.abs(value[i][0] - value[i+1][0]) + Math.abs(value[i][1] - value[i+1][1]);
			}
			// 마지막 고객과 집까지 거리
			sum += (Math.abs(h[0] - value[n-1][0]) + Math.abs(h[1] - value[n-1][1]));
			if(sum < min) {
				min = sum;
			}
			return;
		}
		// 순열
		for(int i = 0; i < n; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				value[cnt][0] = num[i][0];
				value[cnt][1] = num[i][1];
				check(cnt+1);
				isVisited[i] = false;
			}
		}
	}
}