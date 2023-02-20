import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] num;
	static int white, blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N 배열의 크기
		int N = Integer.parseInt(st.nextToken());
		// num 배열
		num = new int[N][N];
		// num 배열 할당
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0,0,N);
		// 하얀색 색종이
		System.out.println(white);
		// 파란색 색종이
		System.out.println(blue);
	}
	
	public static void cut(int r, int c, int size) {
		// 파란색 종이의 개수
		int sum = 0;
		for(int i = r; i < r + size; i++) {
			for( int j = c; j < c+size; j++) {
				sum += num[i][j];
			}
		}
		
		if(sum == size * size) { // 모두 파란색
			blue++;
		} else if(sum == 0) { // 모두 하얀색
			white++;
		} else { // 혼합된 상황
			// 4분할
			int half = size/2;
			// 분할 후 좌상단 구역
			cut(r, c, half);
			// 분할 후 우상단 구역
			cut(r, c+half, half);
			// 분할 후 좌하단 구역
			cut(r+half, c, half);
			// 분할 후 우하단 구역
			cut(r+half, c+half, half);
		}
	}
}