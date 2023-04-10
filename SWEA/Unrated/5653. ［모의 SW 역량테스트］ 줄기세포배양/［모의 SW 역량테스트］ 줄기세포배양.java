import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	//세포 클래스
	static class Cell {
		// 좌표, 비활성화 시간, 활성화 시간, 상태 0 비활성화 1 활성화 2 죽음
		int x, y, unactive, active, status;
		
		public Cell(int x, int y, int unactive, int active, int status) {
			this.x = x;
			this.y = y;
			this.unactive = unactive;
			this.active = active;
			this.status = status;
		}
	}
	
	static int T, N, M, K, map[][];
	static boolean isCell[][];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Cell> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// T 테스트 케이스
		T = parseInt(br.readLine().trim());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			// N 행
			N = parseInt(st.nextToken());
			// M 열
			M = parseInt(st.nextToken());
			// K 배양 시간 
			K = parseInt(st.nextToken());
			// 맵
			map = new int[650][650];
			// 세포 리스트
			list = new ArrayList<Cell>();
			// 세포가 번식했는지
			isCell = new boolean[650][650];
			for(int i = 300; i < 300+N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 300; j < 300+M; j++) {
					map[i][j] = parseInt(st.nextToken());
					if(map[i][j] > 0) {
						isCell[i][j] = true;
						list.add(new Cell(i, j, map[i][j], map[i][j], 0));
					}
				}
			}
			
			for(int i = 1; i <= K; i++) {
				int size = list.size();
				// 세포 상태 변경
				for(int j = 0; j < size; j++) {
					change(j);
				}
				// 세포 번식 확정
				for(int j = 0; j < list.size(); j++) {
					isCell[list.get(j).x][list.get(j).y] = true;
				}
				// 죽은 세포 삭제
				dead();
			}
			sb.append('#').append(tc).append(' ').append(list.size()).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void change(int index) {
		Cell a = list.get(index);
		// 세포의 생명력
		int s = map[a.x][a.y];
		// 상태별 시간감소
		if(a.status == 0) {
			a.unactive--;
		} else if (a.status == 1) {
			a.active--;
		}
		// 상태변경
		if(a.unactive == 0 && a.status == 0) {
			a.status = 1;
		} else if (a.active == s-1 && a.status == 1) {
			// 번식
			for(int i = 0; i < 4; i++) {
				int mx = a.x + dx[i];
				int my = a.y + dy[i];
				if(map[mx][my] == 0) {
					map[mx][my] = s;
					list.add(new Cell(mx, my, s, s, 0));
				} else if(map[mx][my] != 0 && !isCell[mx][my]) {
					// 아직 번식 확정이 아니라면 생명력이 더 높은 세포로 번식
					if(map[mx][my] < s) {
						for(int j = 0; j < list.size(); j++) {
							if(list.get(j).x == mx && list.get(j).y == my) {
								list.get(j).active = s;
								list.get(j).unactive = s;
							}
						}
					}
				}
			}
		}
		// 시간이 모두 감소했으면 죽음
		if(a.active == 0 && a.status == 1) {
			a.status = 2;
		}
		// 세포 상태 변경
		list.set(index, a);
	}
	// 죽은 세포 리스트에서 삭제
	public static void dead() {
		for(int i = list.size()-1; i >= 0; i--) {
			if(list.get(i).status == 2) {
				list.remove(i);
			}
		}
	}

}