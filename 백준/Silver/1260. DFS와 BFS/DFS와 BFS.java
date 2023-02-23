import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int V;
	static int[][] adjMatrix;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		// V 정점의 개수
		V = parseInt(st.nextToken());
		// E 간선의 개수
		int E = parseInt(st.nextToken());
		// S 시작할 정점번호
		int S = parseInt(st.nextToken());
		// 인접행렬 배열
		adjMatrix = new int[V+1][V+1];
		
		int from, to;
		// 배열 할당 및 간선 연결
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = parseInt(st.nextToken());
			to = parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		// 방문 여부
		visited = new boolean[V+1];
		dfs(S);
		sb.append("\n");
		bfs(S);
		System.out.println(sb);

	}
	
	public static void dfs(int start) {
		// 시작 정점 방문
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 1; i < V+1; i++) {
			// 정점과 연결된 정점 확인 후 방문체크 후 재귀
			if(adjMatrix[start][i] != 0 && !visited[i]){
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V+1];
		//시작 정점 offer 후 방문처리
		q.offer(start);
		visited[start] = true;
		
		int current = 0;
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			// current에 정점 할당
			current = q.poll();
			sb.append(current).append(" ");
			
			for(int i = 1; i < V+1; i++) {
				// 큐에 연결된 정점들을 offer
				if(adjMatrix[current][i] != 0 && !visited[i]){
					q.offer(i);
					visited[i] = true;
				}
			}
		}	
	}
}