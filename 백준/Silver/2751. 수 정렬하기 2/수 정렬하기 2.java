import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int n = parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i = 0; i < n; i++) {
			q.add(parseInt(br.readLine()));
		}
		while(!q.isEmpty()) {
			sb.append(q.poll()).append('\n');
		}
		System.out.println(sb);
    }
}