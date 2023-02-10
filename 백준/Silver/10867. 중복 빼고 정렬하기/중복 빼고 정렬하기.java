import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		count = new int[2001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(num[i] > 0) {
				count[1000+num[i]]++;
			} else {
				count[1000 + num[i]]++;
			}
		}
		for(int i = 0; i < 2001; i++) {
			if(count[i] > 0 && i < 1001) {
				sb.append(-(1000-i)).append(" ");
			} else if(count[i] > 0 && i > 1000) {
				sb.append(i-1000).append(" ");
			}
		}
		System.out.println(sb);
	}
}
