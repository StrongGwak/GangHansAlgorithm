import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;
public class Main {

	static int N, M, num[][], con;
	static boolean p[], visited[][], check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		num = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		p = new boolean[N+1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			num[a][b] = 1;
			num[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			check = false;
			dfs(i);
			if(check) {
				con++;
			} else if(!p[i]) {
				con++;
			}
			
		}
		System.out.println(con);
		
	}
	
	public static void dfs(int start) {
		for(int i = 1; i <= N; i++) {
			if(num[start][i] == 1 && !visited[start][i]) {
				p[start] = true;
				p[i] = true;
				check = true;
				visited[start][i] = true;
				visited[i][start] = true;
				dfs(i);
			}
		}
	}
}