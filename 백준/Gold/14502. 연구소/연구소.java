import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][], virus[][], vNum, safe, max, vMap[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		map = new int[N][M];
		vMap = new int[N][M];
		virus = new int[10][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus[vNum][0] = i;
					virus[vNum++][1] = j;
				}
			}
		}
		combination(0);
		System.out.println(max);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] v = q.poll();
			for (int i = 0; i < 4; i++) {
				int mx = v[0] + dx[i];
				int my = v[1] + dy[i];
				if (mx >= 0 && mx < N && my >= 0 && my < M && vMap[mx][my] == 0) {
					vMap[mx][my] = 2;
					q.add(new int[] { mx, my });
				}
			}
		}
		return;
	}

	public static void combination(int cnt) {
		if (cnt == 3) {
			for(int i = 0; i < N; i++) {
				vMap[i] = Arrays.copyOf(map[i],M);
			}
			for (int i = 0; i < vNum; i++) {
				bfs(virus[i][0], virus[i][1]);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (vMap[i][j] == 0) {
						safe++;
					}
				}
			}
			if (safe > max) {
				max = safe;
			}
			safe = 0;
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					combination(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}

}