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
		int x, y, z;
		
		public Tomato(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static ArrayList<Tomato> list;
	static int C, R, box, map[][][], day;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0 ,0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = parseInt(st.nextToken());
		R = parseInt(st.nextToken());
		box = parseInt(st.nextToken());
		map = new int[R][C][box];
		list = new ArrayList<Tomato>();
		for(int b = 0; b < box; b++) {
			for(int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < C; j++) {
					map[i][j][b] = parseInt(st.nextToken());
					if(map[i][j][b] == 1) {
						list.add(new Tomato(i, j, b));
					}
				}
			}
		}
		day = -1;
		ripe();
		for(int b = 0; b < box; b++) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j][b] == 0) {
						day = -1;
					}
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
				for(int i = 0; i < 6; i++) {
					int mx = t.x + dx[i];
					int my = t.y + dy[i];
					int mz = t.z + dz[i];
					if(mx >= 0 && mx < R && my >= 0 && my < C && mz >= 0 && mz < box && map[mx][my][mz] == 0) {
						map[mx][my][mz] = 1;
						q.add(new Tomato(mx,my,mz));
					}
				}
			}
			day++;
		}
	}

}