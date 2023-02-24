import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int N, M, result;
	static ArrayList<ArrayList<Integer>> num;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N 사람의 수
		N = parseInt(st.nextToken());
		// M 친구 관계의 수
		M = parseInt(st.nextToken());
		// num 간선
		num = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			num.add(new ArrayList<>());
		}
		// 간선 연결
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = parseInt(st.nextToken());
			int to = parseInt(st.nextToken());
			num.get(from).add(to);
			num.get(to).add(from);
		}
		for(int i = 0; i < N; i++ ) {
			// visited 방문체크
			visited = new boolean[N];
			// 방문 확인
			visited[i] = true;
			dfs(i,0);
			visited[i] = false;
			if(result == 1) {
				System.out.println(result);
				break;
			}
		}
		if(result == 0) {
			System.out.print(result);
		}
	}
	
	public static void dfs(int start, int cnt) {
		// depth가 4가 되면 result가 1이고 리턴
		if(result == 1) {
			return;
		}
		if(cnt == 4) {
			result = 1;
			return;
		}
		for(int i : num.get(start)) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}
}