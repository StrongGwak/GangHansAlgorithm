import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int T, N, graph[],result;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine());
			graph = new int[N+1];
			visited = new boolean[N+1];
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				graph[i] = parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= N; i++) {
				dfs(i, false);
			}
			System.out.println(result);
		}
	}
	
	public static void dfs(int start, boolean isCycle) {
		if(!visited[start]) {
			visited[start] = true;
			dfs(graph[start], true);
		} else if (isCycle) {
			result++;
		}
	}

}