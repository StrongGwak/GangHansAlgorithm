import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M, max, sum, x, y, way;
	static int[] dx, dy;
	static int[][] flys, catcher;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flys = new int[N][N];
			catcher = new int[M][M];
			dx = new int[] { 1, 0, -1 };
			dy = new int[] { 0, 1, 0 };
			x = 0;
			y = 0;
			sum = 0;
//			int check = 0;
			max = Integer.MIN_VALUE;
			//방향 0 우, 1 하, 1 좌
			way = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					flys[i][j] = Integer.parseInt(st.nextToken());
					// 처음 파리채 값 max에 할당
					if (i < M && j < M) {
						sum += flys[i][j];
						max = sum;
					}
				}
			}
//			for(int h = 0; h <= N-M; h++) {
//				for(int k = 0; k <= N-M; k++) {
//					for (int i = 0; i < N; i++) {
//						for (int j = 0; j < N; j++) {
//							if (h <= i && i < M+h && k <= j && j < M+k) {
//								check += flys[i][j];
//								if(check == 428) {
//									System.out.println(i + " " + j);
//								}
//							}
//						}
//					}
//					System.out.println(check);
//					check = 0;
//					
//				}
//			}
			for (int i = M; i <= N; i++) {
				//x의 끝 좌표는 M-1
				x = M - 1;
				//방향이 오른쪽이면
				if (way == 0) {
					for (int j = 0; j < N - M; j++) {
						//한칸 오른쪽으로 이동
						x += dx[way];
						y += dy[way];
						for (int k = 0; k < M; k++) {
							//이전 열의 값을 빼주고
							sum -= flys[y + k][j];
							//다음 열의 값을 더한다
							sum += flys[y + k][x];
						}
						//최댓값 비교
						if (sum > max) {
							max = sum;
						}
						//만약 끝에 도착하면 밑으로 이동
						if (j == N - M - 1 && i != N) {
							way = 1;
							x += dx[way];
							y += dy[way];
							for (int k = 0; k < M; k++) {
								//이전 행의 값을 빼고
								sum -= flys[y - 1][x - k];
								//다음 행의 값을 더한다
								sum += flys[y + M - 1][x - k];
							}
							if (sum > max) {
								max = sum;
							}
							// 방향은 왼쪽으로
							way = 2;
						}
					}
				} else { // 방향이 왼쪽이면
					// x의 왼쪽 끝 좌표는 N - M이다
					x = N - M;
					for (int j = N - 1; j >= M; j--) {
						x += dx[way];
						y += dy[way];
						for (int k = 0; k < M; k++) {
							// 이전 열의 값을 빼고
							sum -= flys[y + k][j];
							// 다음 열의 값을 더한다
							sum += flys[y + k][x];
						}
						// 최댓값 비교
						if (sum > max) {
							max = sum;
						}
						// 왼쪽 끝에 도착했으면 아래로 진행
						if (j == M && i != N) {
							way = 1;
							x += dx[way];
							y += dy[way];
							for (int k = 0; k < M; k++) {
								//이전 행의 값을 빼고
								sum -= flys[y - 1][x + k];
								//다음 행의 값을 더한다
								sum += flys[y + M - 1][x + k];
							}
							if (sum > max) {
								max = sum;
							}
							// 방향을 오른쪽으로
							way = 0;
						}
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}

}
