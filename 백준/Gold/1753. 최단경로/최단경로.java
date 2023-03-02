import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int V, E, start, distance[];
	static final int  INF = Integer.MAX_VALUE;
	static List<Node>[] list;
	
	static class Node implements Comparable<Node> {
		int end, weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = parseInt(st.nextToken());
		E = parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		start = parseInt(st.nextToken());
		// list 인접리스트
		list = new ArrayList[V+1];
		for(int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = parseInt(st.nextToken());
			int to = parseInt(st.nextToken());
			int value = parseInt(st.nextToken());
			list[from].add(new Node(to, value));
		}
		
		distance = new int[V+1];
		// 모든 값을 INF로 초기화
		Arrays.fill(distance, INF);
		
		dijkstra(start);
		for(int i = 1; i < V+1; i++) {
			System.out.println(distance[i] != INF ? distance[i] : "INF");
		}
	}
	
	public static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean[] visited = new boolean[V+1];
		// 시작 정점 pq에 넣기
		pq.offer(new Node(s, 0));
		distance[s] = 0;
		while(!pq.isEmpty()) {
			// p 현재 정점 노드
			Node p = pq.poll();
			// 현재 정점 번호
			int current = p.end;
			
			if(visited[current]) {
				continue;
			}
			visited[current] = true;
			// 현재 정점의 간선 정보
			for(Node node : list[current]) {
				// 최단 경로 구하고 다음 정점 넣기
				if(distance[node.end] > distance[current] + node.weight) {
					distance[node.end]= distance[current] + node.weight;
					pq.add(new Node(node.end, distance[node.end]));
				}
			}
		}
	}
}