import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {
	static Deque<String>[] gears;
	static Deque<String> gear1, gear2, gear3, gear4;
	static boolean rotated[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// T 테스트케이스
		int T = parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			// result 점수
			int result = 0;
			// K 회전 횟수
			int K = parseInt(br.readLine());
			// gears 톱니바퀴 배열 1,2,3,4 톱니바퀴 덱
			gears = new Deque[5];
			gear1 = new ArrayDeque<String>();
			gear2 = new ArrayDeque<String>();
			gear3 = new ArrayDeque<String>();
			gear4 = new ArrayDeque<String>();
			gears[1] = gear1;
			gears[2] = gear2;
			gears[3] = gear3;
			gears[4] = gear4;
			// 톱니바퀴 정보 할당
			for(int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 8; j++) {
					gears[i].offer(st.nextToken());
				}
			}
			// 회전
			for(int i = 0; i < K; i++) {
				// 회전 여부
				rotated = new boolean[5];
				st = new StringTokenizer(br.readLine(), " ");
				// index 회전할 톱니바퀴 번호
				int index = parseInt(st.nextToken());
				// rot 회전 방향
				int rot = parseInt(st.nextToken());
				rotation(index, rot);
			}
			// 점수 계산
			for(int i = 1; i < 5; i++) {
				if(gears[i].peekFirst().equals("1")) {
					int num = 1;
					for(int j = 1; j < i; j++ ) {
						num *= 2;
					}
					result += num;
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void rotation(int index, int rot) {
		// nextRot 다음 톱니바퀴 회전 방향
		int nextRot = 0;
		if(rot == 1) {
			nextRot = -1;
		} else {
			nextRot = 1;
		}
		// 회전 여부 체크
		rotated[index] = true;
		// 이전 톱니바퀴
		int rear = index - 1;
		// 다음 톱니바퀴
		int next = index + 1;
		// 튀어나온곳끼리 값이 다른지 확인
		if(rear > 0 && !rotated[rear]) {
			// 이전 톱니 덱의 3번째 값과 현재 톱니 덱의 7번째 값 비교
			String poll1 = gears[rear].pollFirst();
			String poll2 = gears[rear].pollFirst();
			String poll3 = gears[index].pollLast();
			if(!gears[rear].peekFirst().equals(gears[index].peekLast())) {
				// 값 다시 넣고 회전
				gears[rear].offerFirst(poll2);
				gears[rear].offerFirst(poll1);
				gears[index].offerLast(poll3);
				rotation(rear, nextRot);
			} else {
				gears[rear].offerFirst(poll2);
				gears[rear].offerFirst(poll1);
				gears[index].offerLast(poll3);
			}
		}
		if(next < 5 && !rotated[next]) {
			// 현재 톱니 덱의 3번째 값과 다음 톱니 덱의 7번째 값 비교
			String poll1 = gears[index].pollFirst();
			String poll2 = gears[index].pollFirst();
			String poll3 = gears[next].pollLast();
			if(!gears[index].peekFirst().equals(gears[next].peekLast())) {
				gears[index].offerFirst(poll2);
				gears[index].offerFirst(poll1);
				gears[next].offerLast(poll3);
				rotation(next, nextRot);
			} else {
				gears[index].offerFirst(poll2);
				gears[index].offerFirst(poll1);
				gears[next].offerLast(poll3);
			}
		}
		// 회전 방향에 따라서 톱니바퀴 회전
		if(rot == 1) {
			gears[index].offerFirst(gears[index].pollLast());
		} else {
			gears[index].offerLast(gears[index].pollFirst());
		}
	}
}