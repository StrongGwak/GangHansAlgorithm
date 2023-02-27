import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {
	static int parents[];
	static boolean relation[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// T 테스트케이스 수
		int T = parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			// result 관계 수
			int result = 0;
			// n 사람 수
			int n = parseInt(st.nextToken());
			parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			// m 관계 수
			int m = parseInt(st.nextToken());
			// 관계 맺어주기
			for (int i = 1; i <= m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = parseInt(st.nextToken());
				int b = parseInt(st.nextToken());
				union(a, b);
			}
			// 집합의 대표 구분
			relation = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				relation[findSet(i)] = true;
			}
			// 대표의 수만큼 result 값 증가
			for (int i = 1; i <= n; i++) {
				if (relation[i]) {
					result++;
				}
			}
			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	// 속한 집합찾기
	static int findSet(int a) {
		// 자신의 부모와 자신이 같으면 자신이 부모
		if (parents[a] == a) {
			return a;
		}
		// pass compression : 내가 속한 root node 반환
		return parents[a] = findSet(parents[a]);
	}

	// 두 집합 합치기
	static boolean union(int a, int b) {
		// a 의 루트 노드 할당
		int aRoot = findSet(a);
		// b 의 루트 노드 할당
		int bRoot = findSet(b);
		// a, b의 root가 동일하므로 같은 집합이므로 합치지못함
		if (aRoot == bRoot) {
			return false;
		}
		// aRoot(집합)에 bRoot(집합) 합치기
		parents[bRoot] = aRoot;
		return true;
	}
}