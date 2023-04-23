import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static HashMap<Integer, Integer> map;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		map = new HashMap<Integer, Integer>();
		visited = new boolean[101];
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(parseInt(st.nextToken()), parseInt(st.nextToken()));
		}
		dice();
		System.out.println(result);
	}
	
	public static void dice() {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {
				int x = q.poll();
				if(x == 100) {
					return;
				}
				for(int i = 0; i < 6; i++) {
					x++;
					if(x < 100 && map.get(x) != null) {
						visited[map.get(x)] = true;
						q.add(map.get(x));
					} else if(x <= 100 && !visited[x]){
						visited[x] = true;
						q.add(x);
					}
				}
			}
			result++;
		}
	}

}