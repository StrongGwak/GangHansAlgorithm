import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int x, y, broken, move;
		public Node(int x, int y, int broken, int move) {
			this.x = x;
			this.y = y;
			this.broken = broken;
			this.move = move;
		}
	}
	
	static int N, M, map[][];
	static int dx[] = {1 , -1, 0, 0}; 
	static int dy[] = {0 , 0, 1, -1}; 
	static boolean visited[][][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = a.charAt(j)-48;
			}
		}
		System.out.println(move());

	}
	
	public static int move() {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.x == N-1 && node.y == M-1) {
				return node.move;
			}
			for(int i = 0; i < 4; i++) {
				int mx = node.x + dx[i];
				int my = node.y + dy[i];
				if(mx >= 0 && mx < N && my >= 0 && my < M  && !visited[mx][my][node.broken]) {
					if(map[mx][my] == 0) {
						visited[mx][my][node.broken] = true;
						q.add(new Node(mx, my, node.broken, node.move+1));
					} else if(map[mx][my] == 1 && node.broken == 0) {
						visited[mx][my][node.broken] = true;
						q.add(new Node(mx, my, node.broken+1, node.move+1));
					}
				}
			}
		}
		return -1;
	}

}