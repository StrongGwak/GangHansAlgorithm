import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//N 열의 크기
		int N = Integer.parseInt(st.nextToken());
		//M 행의 크기
		int M = Integer.parseInt(st.nextToken());
		//R 연산 횟수
		int R = Integer.parseInt(st.nextToken());
		//임시 배열 생성
		String[][] tmp;
		//배열 값 할당
		String[][] num = new String[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				num[i][j] = st.nextToken();
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int k = 1; k <= R; k++) {
			// P 연산 번호
			int P = Integer.parseInt(st.nextToken());
			if(P == 1) { // 상하반전
				tmp = new String[1][1];
				for(int i = 0; i < num.length/2; i++) {
					for(int j = 0; j < num[i].length; j++) {
						tmp[0][0] = num[i][j];
						num[i][j] = num[num.length-1-i][j];
						num[num.length-1-i][j] = tmp[0][0];
					}
				}
			} else if(P == 2) { // 좌우반전
				tmp = new String[1][1];
				for(int i = 0; i < num.length; i++) {
					for(int j = 0; j < num[i].length/2; j++) {
						tmp[0][0] = num[i][j];
						num[i][j] = num[i][num[i].length-1-j];
						num[i][num[i].length-1-j] = tmp[0][0];
					}
				}
			} else if(P == 3) { // 오른쪽으로 90도 회전
				tmp = new String[num[0].length][num.length];
				for(int i = 0; i < num[0].length; i++) {
					for(int j = 0; j < num.length; j++) {
						tmp[i][j] = num[num.length-1-j][i];
					}
				}
				num =  new String[num[0].length][num.length];
				for(int i = 0; i < num.length; i++) {
					for(int j = 0; j < num[i].length; j++) {
						num[i][j] = tmp[i][j];
					}
				}
			} else if(P == 4) { // 왼쪽으로 90도 회전
				tmp =  new String[num[0].length][num.length];
				for(int i = 0; i < num[0].length; i++) {
					for(int j = 0; j < num.length; j++) {
						tmp[i][j] = num[j][num[0].length-1-i];
					}
				}
				num =  new String[num[0].length][num.length];
				for(int i = 0; i < num.length; i++) {
					for(int j = 0; j < num[i].length; j++) {
						num[i][j] = tmp[i][j];
					}
				}
			} else if(P == 5) { // 1 -> 2 -> 3 -> 4
				tmp = new String[num.length][num[0].length];
				for(int i = 0; i < num.length/2; i++) {
					for(int j = 0; j < num[i].length/2; j++) {
						tmp[i][j] = num[i][j];
						num[i][j] = num[i+num.length/2][j];
					}
				}
				
				for(int i = num.length/2; i < num.length; i++) {
					for(int j = 0; j < num[i].length/2; j++) {
						num[i][j] = num[i][j+num[i].length/2];
					}
				}
				
				for(int i = num.length/2; i < num.length; i++) {
					for(int j = num[i].length/2; j < num[i].length; j++) {
						num[i][j] = num[i-num.length/2][j];
					}
				}
				
				for(int i = 0; i < num.length/2; i++) {
					for(int j = num[i].length/2; j < num[i].length; j++) {
						num[i][j] = tmp[i][j-num[i].length/2];
					}
				}
				
			} else if(P == 6) { // 1 -> 4 -> 3 -> 2 -> 1
				tmp = new String[num.length][num[0].length];
				for(int i = 0; i < num.length/2; i++) {
					for(int j = 0; j < num[i].length/2; j++) {
						tmp[i][j] = num[i][j];
						num[i][j] = num[i][j+num[i].length/2];
					}
				}
				
				for(int i = 0; i < num.length/2; i++) {
					for(int j = num[i].length/2; j < num[i].length; j++) {
						num[i][j] = num[i+num.length/2][j];
								
					}
				}
				
				for(int i = num.length/2; i < num.length; i++) {
					for(int j = num[i].length/2; j < num[i].length; j++) {
						num[i][j] = num[i][j-num[i].length/2];
					}
				}
				
				for(int i = num.length/2; i < num.length; i++) {
					for(int j = 0; j < num[i].length/2; j++) {
						num[i][j] = tmp[i-num.length/2][j];
					}
				}
			}
		}
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				sb.append(num[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}