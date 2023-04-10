import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Solution {
	
	public static class Node {
		int x, y, count, way;
		
		Node(int x, int y, int count, int way) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.way = way;
		}
	}

	static int T, N, M, K, map[][], sum, wayMax[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Node> list;
	static boolean dead[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			// N 맵 크기
			N = parseInt(st.nextToken());
			// M 시간
			M = parseInt(st.nextToken());
			// K 미생물 수
			K = parseInt(st.nextToken());
			sum = 0;
			list = new ArrayList<Node>();
			// 미생물이 죽었는지
			dead = new boolean[K];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				// 세로위치
				int a = parseInt(st.nextToken());
				// 가로위치
				int b = parseInt(st.nextToken());
				// 미생물 수
				int c = parseInt(st.nextToken());
				// 이동방향
				int d = parseInt(st.nextToken())-1;
				list.add(new Node(a,b,c,d));
			}
			for(int t = 1; t <= M; t++) {
				map = new int[N][N];
				wayMax = new int[N][N];
				for(int i = 0; i < list.size(); i++) {
					if(!dead[i]) {
						move(i);
					}
				}
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(!dead[i]) {
					sum += list.get(i).count;
				}
			}
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void move(int index) {
		int mx = list.get(index).x + dx[list.get(index).way];
		int my = list.get(index).y + dy[list.get(index).way];
		if(mx == 0 || mx == N-1 || my == 0 || my == N-1) {
			list.get(index).count /= 2;
			if(list.get(index).count == 0) {
				dead[index] = true;
				return;
			}
			int w = list.get(index).way;
			if(w == 0) {
				list.get(index).way = 1;
			} else if(w == 1) {
				list.get(index).way = 0;
			} else if(w == 2) {
				list.get(index).way = 3;
			} else {
				list.get(index).way = 2;
			}
			list.get(index).x = mx;
			list.get(index).y = my;
			map[mx][my] = index+1;
		} else if(map[mx][my] != 0) {
			int a = map[mx][my]-1;
			if(wayMax[mx][my] == 0) {
				if(list.get(index).count < list.get(a).count) {
					wayMax[mx][my] = list.get(a).count;
					list.get(index).way = list.get(a).way;
				} else {
					wayMax[mx][my] = list.get(index).count;
				}
			} else {
				if(wayMax[mx][my] < list.get(index).count) {
					wayMax[mx][my] = list.get(index).count;
				} else {
					list.get(index).way = list.get(a).way;
				}
			}
			list.get(index).count += list.get(a).count;
			list.get(index).x = mx;
			list.get(index).y = my;
			map[mx][my] = index+1;
			dead[a] = true;
		} else {
			list.get(index).x = mx;
			list.get(index).y = my;
			map[mx][my] = index+1;
		}
	}
}