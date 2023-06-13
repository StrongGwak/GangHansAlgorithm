package boj;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_16933_벽부수고이동하기3 {
	public static class Node {
		int x, y, k, m;
		boolean night;
		
		Node(int x, int y, int k, int m, boolean night){
			this.x = x;
			this.y = y;
			this.k = k;
			this.m = m;
			this.night = night;
		}
	}
	
	static int N, M, K, map[][];
	static boolean visited[][][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N 열
		N = parseInt(st.nextToken());
		// M 행
		M = parseInt(st.nextToken());
		// K 부술 수 있는 횟수
		K = parseInt(st.nextToken());
		map = new int[N][M];
		// 횟수마다 방문처리 따로 해준다.
		visited = new boolean[N][M][K+1];
		// 맵 할당
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = a.charAt(j)-48;
			}
		}
		
		System.out.println(move());
		
	}
	
	public static int move() {
		ArrayDeque<Node> q = new ArrayDeque<Node>();
		q.add(new Node(0, 0, K, 1, false));
		visited[0][0][K] = true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			// 도착 시 이동 횟수 리턴
			if(n.x == (N-1) && n.y == (M-1)) {
				return n.m;
			}
			for(int i = 0; i < 4; i++) {
				int mx = n.x + dx[i];
				int my = n.y + dy[i];
				// 맵 벗어나지않고 미방문 시 실행
				if(mx >= 0 && mx < N && my >= 0 && my < M && !visited[mx][my][n.k]) {
					// 낮이면서 이동 할 곳이 벽이고 부술 횟수가 0이 아니라면 벽 부수고 이동
					if(!n.night && map[mx][my] == 1 && n.k > 0 && !visited[mx][my][n.k-1]) {
						q.add(new Node(mx, my, n.k-1, n.m+1, true));
						visited[mx][my][n.k-1] = true;
					// 밤이면서 이동 할 곳이 벽이고 부술 횟수가 0이 아니라면 제자리에서 대기	
					} else if(n.night && map[mx][my] == 1 && n.k > 0 && !visited[mx][my][n.k-1]) {
						q.add(new Node(n.x, n.y, n.k, n.m+1, false));
					// 이동 할 곳이 벽이 아니라면 이동
					}else if (map[mx][my] == 0) {
						if(n.night) {
							q.add(new Node(mx, my, n.k, n.m+1, false));
							visited[mx][my][n.k] = true;
						} else {
							q.add(new Node(mx, my, n.k, n.m+1, true));
							visited[mx][my][n.k] = true;
						}
					}
				}
			}
		}
		return -1;
	}

}
