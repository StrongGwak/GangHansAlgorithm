import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato {
		int x, y;
		
		public Tomato(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Tomato> list;
	static int C, R, map[][], day;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = parseInt(st.nextToken());
		R = parseInt(st.nextToken());
		map = new int[R][C];
		list = new ArrayList<Tomato>();
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new Tomato(i, j));
				}
			}
		}
		day = -1;
		ripe();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					day = -1;
				}
			}
		}
		System.out.println(day);
	}
	
	public static void ripe() {
		Queue<Tomato> q = new ArrayDeque<>();
		for(int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				Tomato t = q.poll();
				for(int i = 0; i < 4; i++) {
					int mx = t.x + dx[i];
					int my = t.y + dy[i];
					if(mx >= 0 && mx < R && my >= 0 && my < C && map[mx][my] == 0) {
						map[mx][my] = 1;
						q.add(new Tomato(mx,my));
					}
				}
			}
			day++;
		}
	}

}