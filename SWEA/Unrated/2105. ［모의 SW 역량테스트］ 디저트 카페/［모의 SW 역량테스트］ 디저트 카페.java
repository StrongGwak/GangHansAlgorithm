import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, max, map[][], startX, startY;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static boolean visited[][], desert[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = parseInt(br.readLine());
			desert = new boolean[101];
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					startX = i;
					startY = j;
					desert[map[startX][startY]] = true;
					visited[startX][startY] = true;
					move(i, j, 0, 0);
					desert[map[startX][startY]] = false;
					visited[startX][startY] = false;
				}
			}
			if(max == 0) {
				max = -1;
			} else {
				max++;
			}
			sb.append('#').append(test_case).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}

	public static void move(int x, int y, int cnt, int way) {
		for(int i = 0; i < 2; i++) {
			way += i;
			int w = way%4;
			if(way > 4) {
				return;
			}
			int mx = x + dx[w];
			int my = y + dy[w];
			if (cnt > 2 && mx == startX && my == startY) {
				if(max < cnt) {
					max = cnt;
				}
				return;
			}
			if (mx >= 0 && mx < N && my >= 0 && my < N && !visited[mx][my] && !desert[map[mx][my]]) {
				visited[mx][my] = true;
				desert[map[mx][my]] = true;
				move(mx, my, cnt+1, way);
				visited[mx][my] = false;
				desert[map[mx][my]] = false;
			}
		}
	}
}