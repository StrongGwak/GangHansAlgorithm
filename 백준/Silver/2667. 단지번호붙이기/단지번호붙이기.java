import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {
	static int N, map[][], num, house;
	static boolean visited[][];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = (int)a.charAt(j)-48;
				if(map[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					num++;
					list.add(house);
					house = 0;
				}
			}
		}
		Collections.sort(list);
		System.out.println(num);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		house++;
		while(!q.isEmpty()) {
			int[] location = q.poll();
			for(int i = 0; i < 4; i++) {
				int mx = location[0] + dx[i];
				int my = location[1] + dy[i];
				if(mx>=0 && mx < N && my >= 0 && my < N && map[mx][my] == 1 && !visited[mx][my]) {
					visited[mx][my] = true;
					map[mx][my] += num;
					house++;
					q.add(new int[] {mx, my});
				}
			}
		}
	}

}