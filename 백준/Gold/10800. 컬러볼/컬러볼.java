import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static class Ball {
		int index, color, size;
		
		public Ball(int index, int color, int size) {
			this.index = index;
			this.color = color;
			this.size = size;
		}
	}
	static int N, C, S, color[], result[];
	static ArrayList<Ball> balls;
	static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		// N 공의 개수
		N = parseInt(br.readLine());
		color = new int[N+1];
		result = new int[N];
		// balls 공 정보 담은 리스트
		balls = new ArrayList<Ball>();
		// 공 색깔 종류
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// C 공 색깔
			C = parseInt(st.nextToken());
			// S 공 size
			S = parseInt(st.nextToken());
			balls.add(new Ball(i, C, S));
		}
		// 공 size 오름차순으로 정렬
		Collections.sort(balls, new Comparator<Ball>() {
			@Override
			public int compare(Ball o1, Ball o2) {
				return o1.size - o2.size;
			}
		});
		
		int index = 0;
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			Ball b = balls.get(i);
			while(balls.get(index).size < b.size) {
				// size가 작으면 합
				sum += balls.get(index).size;
				// 해당 색의 누적합
				color[balls.get(index).color] += balls.get(index).size;
				index++;
			}
			// 합 - 해당 공의 색깔의 합을 뺌
			result[b.index] = sum - color[b.color];
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
}