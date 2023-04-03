import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T, N, point[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T 테스트 케이스 개수
		T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			// N 편의점 개수
			N = parseInt(br.readLine());
			// 좌표
			StringTokenizer st;
			point = new int[N+2][2];
			visited = new boolean[N+2];
			for(int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = parseInt(st.nextToken());
				point[i][1] = parseInt(st.nextToken());
			}
			
			System.out.println(move());
		}
		
	}
	public static String move(){
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {point[0][0], point[0][1]});
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int[] mp = q.poll();
			if(mp[0]==point[N+1][0] && mp[1]==point[N+1][1]) {
				return "happy";
			}
			for(int i = 0; i < N+2; i++) {
				int distance = (Math.abs(point[i][0]-mp[0]) + Math.abs(point[i][1]-mp[1]));
				if(!visited[i] && distance<=1000) {
					visited[i] = true;
					q.add(new int[] {point[i][0], point[i][1]});
				}
			}
		}
		return "sad";
	}

}