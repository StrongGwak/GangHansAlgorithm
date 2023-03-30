import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maze[][];
	static boolean visited[][];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = (int)a.charAt(j)-48;
			}
		}
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0,1});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] location = q.poll();
			if(location[0] == N-1 && location[1] == M-1) {
				return location[2];
			}
			for(int i = 0; i<4; i++) {
				int mx = location[0]+dx[i];
				int my = location[1]+dy[i];
				if(mx>=0 && mx < N && my >= 0 && my < M && maze[mx][my] == 1 && !visited[mx][my]) {
					visited[mx][my] = true;
					q.add(new int[] {mx,my,location[2]+1});
				}
			}
		}
		return 0;
	}

}