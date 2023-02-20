import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r,c,cnt, x, y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 배열의 크기
		int N = Integer.parseInt(st.nextToken());
		int size = 2;
		while(N != 1) {
			size *= 2;
			N--;
		}
		// r 행
		r = Integer.parseInt(st.nextToken());
		// c 열
		c = Integer.parseInt(st.nextToken());
		// 방을 방문한 횟수
		cnt = 0;
		x = size/2;
		y = size/2;
		cut(0,0,size);	
	}
	
	static void cut(int i, int j, int size) {
		if(i == r && j == c) { // r 행과 c열 에 도착했을때 출력
			System.out.print(cnt);
			return;
		} else {// 도착 못했을때 분할
			// 4분할
			int half = size/2;
			//좌상단 배열
			if(r < y && c < x) {
				x -= half/2;
				y -= half/2;
				cut(i, j, half);
			} else if (r < y && c >= x) {//우상단 배열
				x += half/2;
				y -= half/2;
				// 우상단까지 도달했을시 방문횟수는 half * half
				cnt += half*half;
				cut(i, j+half, half);
			} else if (r >= y && c < x) {//좌하단 배열
				y += half/2;
				x -= half/2;
				// 좌하단까지 도달했을시 방문횟수는 half * half * 2
				cnt +=(half*half) * 2;
				cut(i+half, j, half);
			} else if (r >= y && c >= x) {//우하단 배열
				y += half/2;
				x += half/2;
				// 우하단까지 도달했을시 방문횟수는 half * half * 3
				cnt += (half*half) * 3;
				cut(i+half, j+half, half);
			}
		}
	}
}