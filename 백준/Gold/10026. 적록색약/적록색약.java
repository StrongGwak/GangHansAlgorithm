import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int N, normal, special, num[];
	static int[][] area;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N 구역의 크기
		N = parseInt(st.nextToken());
		// 구역 할당
		area = new int[N][N];
		for(int i = 0; i < N; i++) {
			String colors = br.readLine();
			for(int j = 0; j < N; j++) {
				char color = colors.charAt(j);
				if(color == 'R') {
					area[i][j] = 1;
				} else if(color == 'G') {
					area[i][j] = 2;
				} else {
					area[i][j] = 3;
				}
			}
		}
		// 구역
		num = new int[4];
		// 방문 체크
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					num[area[i][j]]++;
				}
			}
		}
		// 정상의 구역 수
		for(int i = 1; i < 4; i++) {
			normal += num[i];
		}
		// 구역
		num = new int[4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(area[i][j] == 2) {
					area[i][j]--;
				}
			}
		}
		// 방문 체크
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					num[area[i][j]]++;
				}
			}
		}
		// 적록색약의 구역 수
		for(int i = 1; i < 4; i++) {
			special += num[i];
		}
		System.out.println(normal + " " +special);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			// 범위 체크
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				// 방문한적 없는 같은 알파벳인지 체크
				if(visited[nx][ny] == false && area[x][y] == area[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}
}