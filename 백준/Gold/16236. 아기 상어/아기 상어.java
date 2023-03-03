import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	// 상어 정보
	static class Shark {
		int x, y;
		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, sx, sy, size, time, grow, result, map[][];
	static boolean call;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = parseInt(br.readLine());
		// 물고기 정보 할당
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = parseInt(st.nextToken());
				// 상어 좌표
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
		// 상어 초기 사이즈 2
		size = 2;
		// 사이즈와 같은 수의 물고기를 먹어야 크기가 커진다
		grow = size;
		call = true;
		// 먹이를 찾지못하면 엄마 상어를 부른다
		while(call) {
			if(!find(new Shark(sx, sy))) {
				call = false;
			}
		}
		System.out.println(result);

	}
	
	public static boolean find(Shark s) {
		Queue<Shark> q = new ArrayDeque<Shark>();
		// 방문 여부
		boolean[][] visited = new boolean[N][N];
		// 걸린 시간
		time = 0;
		int x = N+1;
		int y = N+1;
		q.offer(s);
		visited[s.x][s.y] = true; 
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int a = 0; a < qSize; a++) {
				// 상어 정보
				Shark p = q.poll();
				// 상어 크기보다 작은 물고기 확인 후 해당 좌표 확인
				if(map[p.x][p.y] != 0 && map[p.x][p.y] < size  ) {
					if(x == p.x &&  y > p.y || (x>p.x)) {
						x = p.x;
						y = p.y;
					}
				}
				// 사방으로 위치 변환
				for(int i = 0; i < 4; i++) {
					int mx = p.x + dx[i];
					int my = p.y + dy[i];
					if(mx >= 0 && my >= 0 && mx < N && my < N && !visited[mx][my] && map[mx][my] <= size) {
						q.offer(new Shark(mx, my));
						visited[mx][my] = true; 
					}
				}
			}
			// 물고기 좌표가 할당됐다면 eat 후 리턴 
			if(x != N+1 && y != N+1) {
				eat(x,y);
				return true;
			}
			// 칸 이동시 시간 증가
			time++;
		}
		return false;
	}
	
	public static void eat(int x, int y) {
		// 상어 좌표 변환
		sx = x;
		sy = y;
		// 해당 물고기 삭제
		map[sx][sy] = 0;
		// 먹어야하는 물고기 수 감소
		grow--;
		// 먹어야하는 물고기가 0이라면 사이즈 증가와 물고기량 초기화
		if(grow == 0) {
			size++;
			grow = size;
		}
		// 결과에 걸린 시간 합
		result += time;
	}
}