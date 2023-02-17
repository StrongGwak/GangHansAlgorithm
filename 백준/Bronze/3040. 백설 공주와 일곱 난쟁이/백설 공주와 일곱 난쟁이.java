import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] smalls, real;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 9명의 난쟁이 배열
		smalls = new int[9];
		// 그중 7명의 난쟁이 배열
		real = new int[7];
		// 9명의 키 할당
		for(int i = 0; i < 9; i++) {
			smalls[i] = Integer.parseInt(br.readLine());
		}
		combination(0,0,0);
		System.out.print(sb);

	}
	
	public static void combination(int cnt, int start, int sum) {
		// 7명의 키를 다 골랐으면 실행
		if(cnt == 7) {
			// 7명의 키의 합이 100이면 실행
			if(sum == 100) {
				// 7명의 키 출력
				for(int i = 0; i < 7; i++) {
					sb.append(real[i]).append("\n");
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			//난쟁이중 cnt번째의 배열에 키의 값 할당
			real[cnt] = smalls[i];
			combination(cnt + 1, i + 1, sum + smalls[i]);
		}
	}
}