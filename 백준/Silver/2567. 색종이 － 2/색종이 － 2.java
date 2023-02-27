import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static boolean[][] black, range;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N 스카프의 개수
		int N = parseInt(st.nextToken());
		// result 검은 천의 둘레
		result = 0;
		// black 검은색 천이 덮였는지 확인
		black = new boolean[102][102];
		// black 검은색 천의 둘레 확인
		range = new boolean[102][102];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// x 행
			int x = parseInt(st.nextToken());
			// y 열
			int y = parseInt(st.nextToken());
			// 검은천 덮기
			for(int k = y; k < y + 10; k++) {
				for(int j = x; j < x + 10; j++) {
					// 검은색이 덮히지않았다면 추가로 덮고 검은천의 넓이 증가
					black[k][j] = true;
				}
			}
		}
		// 둘레 체크를 위한 배열
		for(int i = 0; i <= 101; i++) {
			for(int j = 0; j <= 101; j++) {
				if(black[i][j]) {
					check(i,j);
				}
			}
		}
		System.out.println(result);

	}
	
	public static void check(int x, int y) {
		//4방탐색을 위한 배열
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0,  1, 0, -1};
		
		for(int i = 0; i < 4; i++) {
			// 좌표변경
			int mx = x + dx[i];
			int my = y + dy[i];
			// 맵의 범위를 넘어가지않고
			if(mx >= 0 && my >= 0 && mx <= 101 && my <= 101) {
				// 해당 좌표의 검은천이 덮여있지않다면
				if(!black[mx][my] ) {
					// 둘레여부 true처리 후 둘레 증가
					range[mx][my] = true;
					result++;
				}
			}
		}
	}
}