import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {
	static int N, M, C, honey[][], num[][], max[], maxValue;
	static boolean visited[][], isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		StringBuilder sb = new StringBuilder();
		// T 테스트 케이스
		int T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			// N 벌통의 크기
			N = parseInt(st.nextToken());
			// M 선택할 수 있는 벌통의 개수
			M = parseInt(st.nextToken());
			// C 채취할 수 있는 꿀의 최대 양
			C = parseInt(st.nextToken());
			// 벌통 정보
			honey = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					honey[i][j] = parseInt(st.nextToken());
				}
			}
			// 방문처리
			visited = new boolean[N][N];
			// 일꾼 배열
			num = new int[2][M];
			// 부분 집합 원소 선택 배열
			isSelected = new boolean[M];
			// 최대 수익
			maxValue = 0;
			permutation(0);
			sb.append('#').append(tc).append(' ').append(maxValue).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void permutation(int cnt) {
		// 일꾼 모두 채취 완료했을경우
		if(cnt == 2) {
			max = new int[2];
			// 부분 집합 최댓값 구하기
			Set(0, 0);
			Set(0, 1);
			int m = max[0] + max[1];
			if(maxValue < m) {
				maxValue = m;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j+M-1 < N && !visited[i][j] && !visited[i][j+M-1]) {
					int size = 0;
					// M개까지 채집하기
					for(int k = j; k < j + M; k++) {
						visited[i][k] = true;
						num[cnt][size++] = honey[i][k];
					}
					permutation(cnt+1);
					for(int k = j; k < j + M; k++) {
						visited[i][k] = false;
					}
				}
			}
		}
	}
	
	public static void Set(int cnt, int n) {
		int sum = 0;
		int result = 0;
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				if(isSelected[i]) {
					// 꿀의 양
					sum += num[n][i];
					// 수익
					result += num[n][i] * num[n][i];
				}
			}
			// 최대 꿀의 양보다 낮다면
			if(sum <= C) {
				// 최대 수익 갱신
				if(max[n] < result) {
					max[n] = result;
				}
			}
			return;

		} else {
			// 현재 원소를 부분집합의 구성에 포함
			isSelected[cnt] = true;
			Set(cnt + 1, n);
			// 현재 원소를 부분집합의 구성에 비포함
			isSelected[cnt] = false;
			Set(cnt + 1, n);
		}
	}
}