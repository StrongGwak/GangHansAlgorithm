import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N, M, x1, y1, x2, y2, result;
	static int[][] sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//표의 크기
		N = Integer.parseInt(st.nextToken());
		//합을 구해야 하는 횟수
		M = Integer.parseInt(st.nextToken());
		//구간합을 위한 배열
		sum = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				if(i== 0 && j == 0) {//맨 처음이면 주어진 숫자 할당
					sum[i][j] = Integer.parseInt(st.nextToken());
				} else if(j == 0) {// j배열 맨앞이면 i-1배열의 맨 끝에서 가져와서 합
					sum[i][j] = sum[i-1][N-1] + Integer.parseInt(st.nextToken());
				}else {// 이전 j배열에서 값을 가져와서 합
					sum[i][j] = sum[i][j-1] + Integer.parseInt(st.nextToken());
				}
			}
 		}
		for(int i = 0; i < M; i++) {
			//값 초기화
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken())-1;
			y1 = Integer.parseInt(st.nextToken())-1;
			x2 = Integer.parseInt(st.nextToken())-1;
			y2 = Integer.parseInt(st.nextToken())-1;

			if(x1 == 0 && y1 == 0 && y2 == N-1) { //시작 구간이 처음이면 구간합에서 뺄 필요없다.
				result = sum[x2][y2];
			} else 	if(y1 == 0 && y2 == N-1) { // y1이 0이면 x1-1배열의 맨 뒷배열의 값을 가져온다.
				result += sum[x2][y2] - sum[x1-1][N-1];
			} else {
				// 맨 아랫줄에서부터 y1-1 배열값을 빼는 반복을 x2 - x1 만큼 반복한다.
				for(int j = x2; j >= x1; j--) {
					if(j == 0 && y1-1 >=0) {
						result += sum[j][y2] - sum[j][y1-1];
					} else if(y1 == 0 && j == 0) {
						result += sum[j][y2];
					} else if(y1 == 0) {
						result += sum[j][y2] - sum[j-1][N-1];
					} else {
						result += sum[j][y2] - sum[j][y1-1];
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
