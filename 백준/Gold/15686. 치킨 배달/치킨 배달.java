import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node> al, cl, hl;
	static int M, min, cr, N, tr, mcr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb;
		// N 배열의 크기
		N = Integer.parseInt(st.nextToken());
		// city 도시 배열
		int[][] city = new int[N][N];
		// M 고를 최대 치킨집 갯수
		M = Integer.parseInt(st.nextToken());
		// al 전체 치킨집 좌표 리스트
		al = new ArrayList<Node>();
		// 폐업안한 치킨집 좌표 리스트
		cl = new ArrayList<Node>();
		// 집 좌표 리스트
		hl = new ArrayList<Node>();
		// 최소 도시 치킨 거리
		mcr = Integer.MAX_VALUE;
		Node n;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				// 치킨집 좌료 추가
				if(city[i][j] == 2) {
					n = new Node(i,j);
					al.add(n);
				} else if(city[i][j] == 1) { // 집 좌표 추가
					n = new Node(i,j);
					hl.add(n);
				}
			}
		}
		combination(0,0);
		System.out.println(mcr);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < hl.size(); i++) {
				// 집의 최소 치킨 거리
				min = Integer.MAX_VALUE;
				for(int j = 0; j < cl.size(); j++) {
					// 치킨 거리 구하기
					cr = Math.abs((hl.get(i).x) - (cl.get(j).x)) +
					Math.abs((hl.get(i).y) - (cl.get(j).y)) ;
					// 최소 치킨거리 할당
					if(cr < min) {
						min = cr;
					}
				}
				// 도시 치킨 거리 합
				tr += min;
			}
			// 최소 도시 치킨 거리 구하기
			if(tr < mcr) {
				mcr = tr;
			}
			// 도시 치킨 거리 초기화
			tr = 0;
			return;
		}
		for(int i = start; i < al.size(); i++) {
			cl.add(al.get(i));
			combination(cnt + 1, i + 1);
			cl.remove(cl.size()-1);
		}
	}
	
	// 좌표 저장하는 노드 클래스
	private static class Node {
		public int x;
		public int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
}