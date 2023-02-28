import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void makeSet() {
		parents = new int[V+1];
		for(int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++){
			st = new StringTokenizer(br.readLine(), " ");
			V = parseInt(st.nextToken());
			E = parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = parseInt(st.nextToken());
				int b = parseInt(st.nextToken());
				int c = parseInt(st.nextToken());
				edgeList[i] = new Edge(a, b, c);
			}
			
			Arrays.sort(edgeList);
			
			makeSet();
			long result = 0, count = 0;
			for(Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++count == V - 1) {
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
}