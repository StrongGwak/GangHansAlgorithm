import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int N,M;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		combination(0,1);
	}
	// cnt는 자릿수, start는 중복없이 하기 위한 수
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= N; i++) {
			num[cnt] = i;
			//중복을 없애기 위해선 앞자리 수보다 큰 수를 뽑아야함
			combination(cnt+1, i+1);
		}
	}

}
