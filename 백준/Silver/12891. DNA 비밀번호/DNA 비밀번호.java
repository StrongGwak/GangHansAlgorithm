import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S, P, result, a, c, g, t, firstIndex;
	static String dna;
	static char[] ch;
	static int[] aNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 임의의 문자열 길이
		S = Integer.parseInt(st.nextToken());
		// 비밀번호로 사용할 부분문자열의 길이
		P = Integer.parseInt(st.nextToken());
		// 임의로 만든 문자열
		dna = br.readLine();
		// 포함 되어야할 문자 배열 생성
		ch = new char[] { 'A', 'C', 'G', 'T' };
		// 포함 되어야할 최소 개수 배열 생성
		aNum = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		// 포함 되어야할 최소 개수
		for (int i = 0; i < aNum.length; i++) {
			aNum[i] = Integer.parseInt(st.nextToken());
		}
		// 부분문자열 나누기
		for (int j = 0; j < P; j++) {
			// 같으면 각 문자열에 1씩 추가
			if (ch[0] == dna.charAt(j)) {
				a++;
			} else if (ch[1] == dna.charAt(j)) {
				c++;
			} else if (ch[2] == dna.charAt(j)) {
				g++;
			} else if (ch[3] == dna.charAt(j)) {
				t++;
			}
		}
		if(aNum[0] <= a && aNum[1] <= c && aNum[2] <= g && aNum[3] <= t) {
			result++;
		}
		for (int i = 0; i <= S - P; i++) {
			if(P+i >= S) {
				break;
			}
			// 문자열이 바뀔 때마다 맨앞의 문자열 count는 빼주고
			// 맨 뒤에 올 문자열의 count를 더해준다
			if (ch[0] == dna.charAt(i)) {
				a--;
			} else if (ch[1] == dna.charAt(i)) {
				c--;
			} else if (ch[2] == dna.charAt(i)) {
				g--;
			} else if (ch[3] == dna.charAt(i)) {
				t--;
			}
			if (ch[0] == dna.charAt(P+i)) {
				a++;
			} else if (ch[1] == dna.charAt(P+i)) {
				c++;
			} else if (ch[2] == dna.charAt(P+i)) {
				g++;
			} else if (ch[3] == dna.charAt(P+i)) {
				t++;
			}
			// 체크 후 result에 추가
			if(aNum[0] <= a && aNum[1] <= c && aNum[2] <= g && aNum[3] <= t) {
				result++;
			}
		}
		System.out.println(result);

	}


}
