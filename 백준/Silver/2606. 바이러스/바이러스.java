import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	static int N, M, Con[][], count;
	static boolean visited[][], vc[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 컴퓨터 수
		N = parseInt(br.readLine());
		// 연결 수
		M = parseInt(br.readLine());
		Con = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		StringTokenizer st;
		vc = new boolean[N+1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			Con[a][b] = 1;
			Con[b][a] = 1;
		}
		virus(1);
		
		for(int i = 2; i <= N; i++) {
			if(vc[i]) {
				count++;
			}
		}
		System.out.println(count);
		
		
	}
	
	public static void virus(int start) {
		for(int i = 1; i <= N; i++) {
			if(Con[start][i] == 1 && !visited[start][i] && !visited[i][start]) {
				vc[start] = true;
				vc[i] = true;
				visited[start][i] = true;
				visited[i][start] = true;
				virus(i);
			}
		}
	}

}