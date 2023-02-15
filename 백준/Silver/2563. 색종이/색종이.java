import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// P 색종이 개수
		int P = Integer.parseInt(br.readLine());
		// 도화지의 배열
		int[][] bg = new int[100][100];
		// 검은 영역의 넓이
		int sum = 0;
		for(int t = 0; t < P; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 왼쪽 끝에서 left만큼 떨어진 색종이의 위치
			int left = Integer.parseInt(st.nextToken()) - 1;
			// 밑에서 down만큼 떨어진 색종이의 위치
			int down = Integer.parseInt(st.nextToken()) - 1;
			// 넓이만큼 1로 바꾼다.
			for(int i = down; i < down+10; i++) {
				for(int j = left; j < left+10; j++) {
					bg[i][j] = 1;
				}
			}
		}
		// 1의 개수가 색종이가 덮은 넓이이다.
		for(int i = 0; i < bg.length; i++) {
			for(int j = 0; j < bg[i].length; j++) {
				if(bg[i][j] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}
}