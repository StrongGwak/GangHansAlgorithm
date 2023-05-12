import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Fire {
		int x, y, m, s, d;
		public Fire(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N, M, K, result;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayDeque<Fire> q[][], moveFire;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 맵크기
		N = parseInt(st.nextToken());
		// 파이어볼개수
		M = parseInt(st.nextToken());
		// 이동명령횟수
		K = parseInt(st.nextToken());
		q = new ArrayDeque[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				q[i][j] = new ArrayDeque<Fire>();
			}
		}
		moveFire = new ArrayDeque<Fire>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Fire f = new Fire(parseInt(st.nextToken())-1, parseInt(st.nextToken())-1, parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()));
			moveFire.add(f);
		}
		
		for(int o = 0; o < K; o++) {
			move();
			sum();
		}
		
		while(!moveFire.isEmpty()) {
			Fire f = moveFire.poll();
			result += f.m;
		}
		
		System.out.println(result);
	}
	
	public static void move() {
		while(!moveFire.isEmpty()) {
			Fire f = moveFire.poll();
			int mx = (N + (f.x + (f.s * dx[f.d])%N)) % N;
			int my = (N + (f.y + (f.s * dy[f.d])%N)) % N;
			q[mx][my].add(new Fire(mx, my, f.m, f.s, f.d));
		}
	}
	
	public static void sum() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(q[i][j].size() > 1) {
					slice(q[i][j]);
				} else if(!q[i][j].isEmpty()) {
					moveFire.add(q[i][j].poll());
				}
			}
		}
	}
	
	public static void slice(ArrayDeque<Fire> fs) {
		// m 질량, s 속력, d 방향
		int size = fs.size();
		int x = 0;
		int y = 0;
		int m = 0;
		int s = 0;
		int prev = 3;
		boolean change = false;
		while(!fs.isEmpty()) {
			Fire f = fs.poll();
			x = f.x;
			y = f.y;
			m += f.m;
			s += f.s;
			if(prev == 3) {
				prev = f.d%2;
			}
			if(prev != f.d%2) {
				change = true;
			}
		}
		m /= 5;
		if(m == 0) {
			return;
		}
		s /= size;
		if(!change) {
			for(int i = 0; i < 7; i+=2) {
				moveFire.add(new Fire(x, y, m, s, i));
			}
		} else {
			for(int i = 1; i < 8; i+=2) {
				moveFire.add(new Fire(x, y, m, s, i));
			}
		}
	}

}