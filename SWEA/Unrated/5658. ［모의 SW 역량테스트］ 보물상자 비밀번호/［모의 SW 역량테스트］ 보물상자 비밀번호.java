import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {
	static int N, K;
	static ArrayDeque<String> q;
	static HashSet<Integer> hs;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = parseInt(st.nextToken());
			K = parseInt(st.nextToken());
			q = new ArrayDeque<String>();
			hs = new HashSet<Integer>();
			String[] a = new String[N];
			a = br.readLine().split("");
			for(int i = 0; i < N; i++) {
				q.offer(a[i]);
			}
			for(int k = 0; k < N-1; k++) {
				for(int i = 0; i < N/4; i++) {
					String str = "";
					for(int j = 0; j < N/4; j++) {
						// 문자열 N/4개로 자르고
						String cur = q.poll();
						str += cur;
						q.offer(cur);
					}
					// 10진수로 바꾸고 HashSet에 담기
					hs.add(parseInt(str, 16));
				}
				// 회전
				String rot = q.poll();
				q.offer(rot);
			}
			// 정렬
			ArrayList<Integer> al = new ArrayList<>(hs);
			Collections.sort(al);
			sb.append('#').append(tc).append(' ').append(al.get(al.size()-K)).append('\n');
		}
		System.out.print(sb);
	}
}