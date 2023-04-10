import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, map[][], stair[][], min, P, people[][], S, go[], pd[][], K[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 맵크기
			N = parseInt(br.readLine());
			// 사람수
			P = 0;
			// 계단
			S = 0;
			// 최솟값
			min = Integer.MAX_VALUE;
			// 사람위치
			people = new int[11][2];
			// 계단 위치
			stair = new int[2][2];
			// 맵
			map = new int[N][N];
			// 계단 내려가는데 걸리는 시간
			K = new int[2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken());
					if (map[i][j] == 1) {
						people[P][0] = i;
						people[P][1] = j;
						P++;
					} else if (map[i][j] != 0) {
						stair[S][0] = i;
						stair[S][1] = j;
						K[S] = map[i][j];
						S++;
					}
				}
			}
			// 거리
			pd = new int[11][2];
			// 사람과 계단사이 거리구하기
			for (int i = 0; i < N; i++) {
				pd[i][0] = Math.abs(people[i][0] - stair[0][0]) + Math.abs(people[i][1] - stair[0][1]);
				pd[i][1] = Math.abs(people[i][0] - stair[1][0]) + Math.abs(people[i][1] - stair[1][1]);
			}
			// 계단 선택
			go = new int[P];
			go(0);

			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.println(sb);
	}

	public static void go(int cnt) {
		// 계단 선택 경우의수
		if (cnt == P) {
			// 계단 내려가는 메서드
			move();
			return;
		}
		for (int i = 0; i < 2; i++) {
			go[cnt] = i;
			go(cnt + 1);
		}
	}

	public static void move() {
		//계단 큐
		PriorityQueue<Integer> pq0 = new PriorityQueue<>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		// 선택한 계단에 따라 추가
		for (int i = 0; i < P; i++) {
			if (go[i] == 0) {
				pq0.add(pd[i][0]);
			} else {
				pq1.add(pd[i][1]);
			}
		}
		
		// 남은 사람수
		int pNum = P;
		//계단 최대 이용자
		int[] stair0 = new int[3];
		int[] stair1 = new int[3];
		
		int time = 0;

		while (true) {
			//종료조건
			if (pNum == 0) {
				boolean flag = true;
				for (int i = 0; i < 3; i++) {
					if (stair0[i] != 0) {
						flag = false;
						break;
					}
					if (stair1[i] != 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			
			for (int i = 0; i < 3; i++) {
				// 이용중이 아니고
				if (stair0[i] == 0) {
					// 대기자 존재하면서
					if (!pq0.isEmpty()) { 
						// 도착했다면
						if (pq0.peek() <= time) {
							// 인원 감소
							pNum--;
							// 내려가는 시간 할당
							stair0[i] = K[0];
							// 대기자 내려보내기
							pq0.poll();
						}
					}
				} else {
					// 내려보내기
					stair0[i]--;
					// 계단을 다 내려갔다면
					if (stair0[i] == 0) {
						if (!pq0.isEmpty()) {
							if (pq0.peek() <= time) {
								pNum--;
								stair0[i] = K[0];
								pq0.poll();
							}
						}
					}
				}
				// 다른 계단도 동시에 진행
				if (stair1[i] == 0) { 
					if (!pq1.isEmpty()) { 
						if (pq1.peek() <= time) {
							pNum--; 
							stair1[i] = K[1];
							pq1.poll();
						}
					}
				} else {
					stair1[i]--;
					if (stair1[i] == 0) {
						if (!pq1.isEmpty()) {
							if (pq1.peek() <= time) {
								pNum--; 
								stair1[i] = K[1];
								pq1.poll();
							}
						}
					}
				}
			} 
			// 시간 증가
			time++;
		}
		// 최솟값
		if (time < min) {
			min = time;
		}
	}
}