import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] quad;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		sb = new StringBuilder();
		// N 배열의 크기
		int N = Integer.parseInt(st.nextToken());
		// quad 배열
		quad = new int[N][N];
		// quad 배열 할당
		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				quad[i][j] = Integer.parseInt(a[j]);
			}
		}
		cut(0,0,N);
		System.out.println(sb);
	}
	public static void cut(int r, int c, int size) {
		// 1의 개수
		int sum = 0;
		for(int i = r; i < r + size; i++) {
			for( int j = c; j < c+size; j++) {
				sum += quad[i][j];
			}
		}
		
		if(sum == size * size) { // 모두 1일때
			sb.append("1");
		} else if(sum == 0) { // 모두 0일때
			sb.append("0");
		} else { // 혼합된 상황
			// 4분할
			int half = size/2;
			// 시작시 괄호 시작
			sb.append("(");
			// 분할 후 좌상단 구역
			cut(r, c, half);
			// 분할 후 우상단 구역
			cut(r, c+half, half);
			// 분할 후 좌하단 구역
			cut(r+half, c, half);
			// 분할 후 우하단 구역
			cut(r+half, c+half, half);
			// 끝날시 괄호 끝
			sb.append(")");
		}
	}

}