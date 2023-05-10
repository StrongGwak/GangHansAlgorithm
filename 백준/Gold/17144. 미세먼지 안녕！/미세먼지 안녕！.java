import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static class Dust {
		int x, y, value;
		public Dust(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	
	static int R, C, T, map[][], cleanerX[], cleanerY[], result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] dx2 = {1, 0, -1, 0};
	static int[] dy2 = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());
		T = parseInt(st.nextToken());
		map = new int[R][C];
		cleanerX = new int[2];
		cleanerY = new int[2];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleanerX[1] = i;
					cleanerY[1] = j;
				}
			}
		}
		cleanerX[0] = cleanerX[1]-1;
		cleanerY[0] = cleanerY[1];
		for(int i = 0; i < T; i++) {
			dust();
			wind();
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	public static void dust() {
		ArrayDeque<Dust> q = new ArrayDeque<Dust>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					int slice = 0;
					int v = map[i][j]/5;
					for(int d = 0; d < 4; d++) {
						int mx = i + dx[d];
						int my = j + dy[d];
						if(mx >= 0 && mx < R && my >= 0 && my < C && map[mx][my] != -1) {
							q.add(new Dust(mx, my, v));
							slice++;
						}
					}
					map[i][j] -= v*slice;
				}
			}
		}
		while(!q.isEmpty()) {
			Dust d = q.poll();
			map[d.x][d.y] += d.value;
		}
	}
	
	public static void wind() {
		int upWay = 0;
		int downWay = 0;
		int upX = cleanerX[0]+dx[upWay];
		int upY = cleanerY[0]+dy[upWay];
		int downX = cleanerX[1]+dx2[downWay];
		int downY = cleanerY[1]+dy2[downWay];
		while(upX+dx[upWay] != cleanerX[0] || upY+dy[upWay] != cleanerY[0]-1) {
			int ux = upX+dx[upWay];
			int uy = upY+dy[upWay];
			if(ux>=0 && ux <= cleanerX[0] && uy >= 0 && uy < C) {
				if(map[ux][uy] != -1) {
					map[upX][upY] = map[ux][uy];
				} else {
					map[upX][upY] = 0;
				}
				upX = ux;
				upY = uy;
			} else {
				upWay++;
			}
		}
		while(downX+dx2[downWay] != cleanerX[1] || downY+dy2[downWay] != cleanerY[1]-1) {
			int dwx = downX+dx2[downWay];
			int dwy = downY+dy2[downWay];
			if(dwx>= cleanerX[1] && dwx < R && dwy >= 0 && dwy < C) {
				if(map[dwx][dwy] != -1) {
					map[downX][downY] = map[dwx][dwy];
				} else {
					map[downX][downY] = 0;
				}
				downX = dwx;
				downY = dwy;
			} else {
				downWay++;
			}
		}
	}
	

}