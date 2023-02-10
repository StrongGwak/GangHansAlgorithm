import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		// 카드 정렬
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(true) {
            // 카드가 한장 남으면 그 카드 출력
			if(q.size() == 1) {
				System.out.println(q.peek());
				break;
			}
			//맨 윗장의 카드 버리기
			q.poll();
			// 그 다음 카드 맨 밑으로 옮기기
			q.offer(q.poll());
		}
	}
}
