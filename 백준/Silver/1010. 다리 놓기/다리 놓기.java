import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int T, N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// T 테스트케이스
		T = parseInt(br.readLine());
		StringTokenizer st;
		// 사이트의 개수
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = parseInt(st.nextToken());
			M = parseInt(st.nextToken());
			Long[][] bridge = new Long[M+1][M+1];
			
			for(int i = 0; i <= M; i++) {
				for(int j = 0, end = Math.min(i, N); j <= end; j++) {
					if(j==0 || i==j) {
						// 양옆끝 1로 할당
						bridge[i][j] = (long) 1;
					} else {
						// 상위 2개의 요소를 더한게 값
						bridge[i][j] = bridge[i-1][j-1] + bridge[i-1][j];
					}
				}
			}
			System.out.println(bridge[M][N]);
		}
	}
}