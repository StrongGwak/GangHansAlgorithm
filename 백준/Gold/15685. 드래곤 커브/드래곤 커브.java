import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] map;
	static ArrayList<Integer> dList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = parseInt(br.readLine());
		map = new boolean[101][101];
		int result = 0;
		for (int i = 0; i < N; i++) {
			dList = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), " ");
			int x = parseInt(st.nextToken());
			int y = parseInt(st.nextToken());
			int d = parseInt(st.nextToken());
			int g = parseInt(st.nextToken());
			map[y][x] = true;
			dList.add(d);
			dc(x, y, g);
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]) {
					if(check(i,j)) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

	public static void dc(int x, int y, int g) {
		int mx = x;
		int my = y;
		for(int i = 1; i <= g; i++) {
			ArrayList<Integer> tmpList = new ArrayList<Integer>();
			for(int j = dList.size()-1; j >= 0; j--) {
				tmpList.add((dList.get(j)+1)%4);
			}
			for(int j = 0; j < tmpList.size(); j++) {
				dList.add(tmpList.get(j));
			}
		}
		for (int i = 0; i < dList.size(); i++) {
			mx += dx[dList.get(i)];
			my += dy[dList.get(i)];
			if (mx >= 0 && my >= 0 && mx <= 100 && my <= 100) {
				map[my][mx] = true;
			}
		}
	}
	
	public static boolean check(int y, int x) {
		int my = y;
		int mx = x;
		int s = 0;
		int[] cy = {0, -1, 0};
		int[] cx = {1, 0, -1};
		for(int i = 0; i < 3; i++) {
			my += cy[i];
			mx += cx[i];
			if (mx >= 0 && my >= 0 && mx <= 100 && my <= 100) {
				if(map[my][mx]) {
					s++;					
				}
			}
		}
		if(s == 3) {
			return true;
		} else {
			return false;
		}
	}
}