import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for(int i = 0; i < M; i++) {
			String p = br.readLine();
			if(map.get(p) != null) {
				pq.add(p);
			}
		}
		sb.append(pq.size()).append('\n');
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append('\n');
		}
		System.out.println(sb);

	}

}