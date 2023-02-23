import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int R, C, max;
	static int[][] board;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// R 행
		R = parseInt(st.nextToken());
		// C 열
		C = parseInt(st.nextToken());
		// 보드 배열
		board = new int[R][C];
		// 알파벳을 정수로 저장
		for(int i = 0; i < R; i++) {
			String a = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = a.charAt(j)-'A';
			}
		}
		// 방문 여부
		visited = new boolean[26];
		dfs(0,0,1);
		System.out.println(max);
	}
	
	public static void dfs(int y, int x, int move) {
		// 현재 좌표 방문처리
		visited[board[y][x]] = true;
		// 최대값 계산
		if(max < move) {
			max = move;
		}
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
	        int my = y + dy[i];
			if(my >= 0 && mx >= 0 && my < R && mx < C ) {
				// 방문하지않은곳이면 재귀
				if(visited[board[my][mx]] == false) {
					dfs(my, mx, move+1);
					visited[board[my][mx]] = false;
				}
			}
		}
	}

}