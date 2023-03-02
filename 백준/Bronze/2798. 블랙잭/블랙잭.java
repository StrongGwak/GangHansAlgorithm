import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int N, M, card[], max, sum, num[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		card = new int[N];
		num = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			card[i] = parseInt(st.nextToken());
		}
		permutation(0, 0);
		System.out.println(max);

	}
	
	public static void permutation(int cnt, int start) {
		if(cnt == 3) {
			for(int i = 0; i < 3; i++) {
				sum+= num[i];
			}
			if(sum <= M) {
				if(max < sum) {
					max = sum;
				}
			}
			sum = 0;
			return;
		}
		
		for(int i = start; i < N; i++) {
			num[cnt] = card[i];
			permutation(cnt + 1, i + 1);
		}
	}
}