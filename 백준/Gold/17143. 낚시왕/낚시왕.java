import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
	static class Shark implements Comparable<Shark> {		// 노드 기준으로 간선 정보를 저장하기 위해 노드의 번호와 가중치를 함께 저장
		int x, y, s, d, z;

		public Shark(int y, int x, int s, int d, int z) {
			this.y = y - 1;		// y좌표
			this.x = x - 1;		// x좌표
			this.s = s;		// 속력
			this.d = d - 1;		// 방향은 0~3이므로 1 빼줌
			this.z = z;		// 크기
		}
		// 좌표로 정렬
		@Override
		public int compareTo(Shark o) {
			if(x==o.x)
				return y-o.y;
			else
				return x-o.x;
		}
	}

	static int R, C, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Shark> sharks;
	static int[] minEdge;
	static StringBuilder sb = new StringBuilder();
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		input();
		int answer = 0;
		sharks.sort(null);

		for (int i = 0; i < C+1; i++) {
			answer += doFishing(i);
			moveShark();
			eatShark();
		}


		System.out.println(answer);
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken()) - 1;		// 최대 행 값
		C = parseInt(st.nextToken()) - 1;		// 최대 열 값
		M = parseInt(st.nextToken());			// 상어의 수
		sharks = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sharks.add(new Shark(
					parseInt(st.nextToken()),
					parseInt(st.nextToken()),
					parseInt(st.nextToken()),
					parseInt(st.nextToken()),
					parseInt(st.nextToken())
			));
		}
	}

	private static int doFishing(int c) {
		for (Shark shark : sharks) {
			// x좌표가 낚시꾼과 같으면 가장 가까운 상어를 잡고 상어 크기만큼 리턴
			if(shark.x==c) {
				int size = shark.z;
				sharks.remove(shark);
				return size;
			}
		}

		return 0;
	}

	private static void moveShark() {
		for (Shark shark : sharks) {
			if(shark.d==0) {		// 위쪽
				// 벽에 붙이기
				int move = Math.abs(shark.s-shark.y);
				if(shark.y-shark.s>=0) {
					shark.y -= shark.s;
					continue;
				}
				// 벽에 부딪히는 횟수가 짝수면 방향전환 홀수면 그대로
				if((move/R)%2==0) {
					// 짝수일때 y좌표 구하기
					shark.y = move%R;
					shark.d = 1;
				} else {
					// 홀수일때 y좌표 구하기
					shark.y = R-(move%R);
				}
			} else if (shark.d == 1) {		// 아래쪽
				int move = Math.abs(shark.s-(R-shark.y));
				if(shark.y+shark.s<=R) {
					shark.y += shark.s;
					continue;
				}

				if((move/R)%2==0) {
					shark.y = R-(move%R);
					shark.d = 0;
				} else {
					shark.y = move%R;
				}
			} else if(shark.d==2) { // 오른쪽
				int move = Math.abs(shark.s-(C-shark.x));
				
				if(shark.x+shark.s<=C) {
					shark.x += shark.s;
					continue;
				}

				if((move/C)%2==0) {
					shark.x = C-(move%C);
					shark.d = 3;
				} else {
					shark.x = move%C;
				}
			} else if(shark.d==3) { // 왼쪽
				int move = Math.abs(shark.s-shark.x);
				if(shark.x-shark.s>=0) {
					shark.x -= shark.s;
					continue;
				}

				if((move/C)%2==0) {
					shark.x = move%C;
					shark.d = 2;
				} else {
					shark.x = C-(move%C);
				}
			} 
		}
	}

	private static void eatShark() {
		// 상어 리스트 좌표로 정렬
		sharks.sort(null);
		// 상어들의 좌표가 같으면 사이즈가 가장 큰 상어만 남고 모두 제거
		for (int i = sharks.size()-1; i >= 1 ; i--) {
			if(sharks.get(i).x==sharks.get(i-1).x &&
					sharks.get(i).y==sharks.get(i-1).y) {
				if(sharks.get(i).z>sharks.get(i-1).z) {
					sharks.remove(i-1);
				} else {
					sharks.remove(i);
				}
			}
		}
	}
}