import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] gas;
	static int result, x, y, R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// R 열
		R = Integer.parseInt(st.nextToken());
		// C 행
		C = Integer.parseInt(st.nextToken());
		gas = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			String[] map = br.readLine().split("");
			for(int j = 0; j < C; j++) {
				if(map[j].equals("x")) {
					gas[i][j] = true;
				}
			}
		}
		// 끝열에 도착한 파이프 개수
		for(int i = 0; i < R; i++) {
			if(check(i,0)) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	public static boolean check(int y, int x) {
		// 끝열에 도착
		if(x == C) {
			return true;
		}
		// y칸을 벗어나거나 중간에 장애물이 있으면 false
		if(y < 0 || y >= R || gas[y][x] == true) {
			return false;
		}
		// 파이프 건설
		gas[y][x] = true;
		//3방향 탐색
		for(int i = -1; i < 2; i++) {
			if(check(y+i, x+1)) {
				return true;
			}
		}
		//3방향 막혀있을때 false
		return false;
	}
}