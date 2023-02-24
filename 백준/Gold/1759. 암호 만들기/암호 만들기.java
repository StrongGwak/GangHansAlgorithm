import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
	static int L, C;
	static boolean[] visited;
	static String[] str, password;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		// L 비밀번호 길이
		L = parseInt(st.nextToken());
		// C 문자의 종류
		C = parseInt(st.nextToken());
		// 문자 배열
		str = new String[C];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) {
			str[i] = st.nextToken();
		}
		// 문자 정렬
		Arrays.sort(str);
		// 방문여부체크
		visited = new boolean[C];
		// 비밀번호 배열
		password = new String[L];
		permutation(0,0);
		System.out.print(sb);
		
	}
	
	public static void permutation(int cnt, int start) {
		// 비밀번호 자리수만큼 조합했다면 출력
		if(cnt == L) {
			// 모음 개수
			int v = 0;
			// 모음 개수 세기
			for(int i = 0; i < L; i++) {
				if(password[i].equals("a") || password[i].equals("e") ||password[i].equals("i") ||
				  password[i].equals("o") ||password[i].equals("u")) {
					v++;
				}
			}
			// 자음 개수
			int c = password.length - v;
			// 모음 개수 1개 이상, 자음 개수 2개 이상
			if(v >= 1 && c >= 2) {
				for(int i = 0; i < L; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
				return;
			} else {
				return;
			}
		}
		
		for(int i = start; i < C; i++) {
			//방문 안했으면
			if(!visited[i]) {
				// 방문 체크
				visited[i] = true;
				// 비밀번호에 문자 할당
				password[cnt] = str[i];
				// 재귀
				permutation(cnt+1, i + 1);
				// 방문 체크 false
				visited[i] = false;
			}
		}
	}
}