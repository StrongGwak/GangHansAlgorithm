import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N, M, i, j;
	static int[] num, sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 수의 갯수
		N = Integer.parseInt(st.nextToken());
		// 합을 구하는 횟수
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		// 수의 배열
		num = new int[N];
		// 각 인덱스까지의 구간합을 담은 배열
		sums = new int[N];
		for(int a = 0; a < N; a++) {
			num[a] = Integer.parseInt(st.nextToken());
			if(a==0) {
				sums[a] = num[a];
			} else {
				sums[a] = num[a] + sums[a-1];
			}
		}
		// M만큼 합 구하기
		for(int a = 0; a < M; a++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 시작구간
			i = Integer.parseInt(st.nextToken())-1;
			// 끝구간
			j = Integer.parseInt(st.nextToken())-1;
			// j번까지의 구간합 - i번까지의 구간합
			if(i == 0) {
				System.out.println(sums[j]);
			} else {
				System.out.println(sums[j] - sums[i-1]);
			}
		}
	}
}
