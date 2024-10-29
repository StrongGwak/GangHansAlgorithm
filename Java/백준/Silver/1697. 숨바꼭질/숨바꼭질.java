import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int N, K, time;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		// N 수빈이의 위치
		N = parseInt(st.nextToken());
		// K 동생의 위치
		K = parseInt(st.nextToken());
		// 방문 여부
		visited = new boolean[100001];
		// 바로 발견시 0 출력
		if(N != K) {
			bfs(N);
			System.out.print(time);
		} else {
			System.out.print(time);
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		// 수빈의 시작 좌표 offer, 방문체크
		q.offer(start);
		visited[start] = true;
		
		int current = 0;
		while(!q.isEmpty()) {
			// 큐의 사이즈
			int size = q.size();
			// 탐색시 시간 증가
			time++;
			for(int t = 0; t < size; t++) {
				// 수빈의 좌표 할당
				current = q.poll();
				// 위치 변환 후 동생과 만났는지 체크
				if(current-1 == K ) {
					return;
				} else if(current - 1 >= 0 && !visited[current - 1]) { // 만나지 못했다면 해당 좌표 offer
					q.offer(current - 1);
					visited[current-1] = true;
				}
				
				if(current+1 == K ) {
					return;
				} else if(current + 1 <= 100000 && !visited[current + 1]) {
					q.offer(current + 1);
					visited[current+1] = true;
				}
				
				if(current*2 == K ) {
					return;
				} else if(current * 2 <= 100000 && !visited[current * 2]) {
					q.offer(current * 2);
					visited[current*2] = true;
				}
			}
		}
	}
}