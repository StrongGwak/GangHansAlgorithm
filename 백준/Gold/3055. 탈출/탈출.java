import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, water[][], cave[], hg[], m[][], mn;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static String map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());
		water = new int[R][C];
		map = new String[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}
		cave = new int[2];
		hg = new int[2];
		m = new int[R*C][2];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j].equals("D")) {
					cave[0] = i;
					cave[1] = j;
				} else if(map[i][j].equals("S")) {
					hg[0] = i;
					hg[1] = j;
				} else if(map[i][j].equals("*")) {
					m[mn][0] = i;
					m[mn][1] = j;
					mn++;
				}
			}
		}
		
		int result = hide();
		if(result == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
		
	}
	
	public static int hide() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < mn; i++) {
			q.add(new int[] {m[i][0], m[i][1], 0, 0});
			visited[m[i][0]][m[i][1]] = true;			
		}
		q.add(new int[] {hg[0], hg[1], 0, 1});
		visited[hg[0]][hg[1]] = true;
		while(!q.isEmpty()) {
			int[] location = q.poll();
			if(location[3] == 1  && location[0] == cave[0] && location[1] == cave[1]) {
				return location[2];
			}
			for(int i = 0; i < 4; i++) {
				int mx = location[0] + dx[i];
				int my = location[1] + dy[i];
				if(mx >= 0 && mx < R && my >= 0 && my < C && !visited[mx][my] && !map[mx][my].equals("X")) {
					if(location[3] == 0 && map[mx][my].equals("D")) {
						
					} else {
						visited[mx][my] = true;
						q.add(new int[] {mx, my, location[2]+1, location[3]});
					}
					
				}
			}
		}
		return -1;
	}
}