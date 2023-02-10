import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		//수를 넣을 배열
		numbers = new int[N];
		//선택여부를 넣을 배열 0은 사용 안하기 때문에 N+1로 만든다.
		isSelected = new boolean[N+1];
		// 순열시작
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		//cnt 순서로 숫자 선택
		if(cnt == N) {
			//모두 선택 됐으면 숫자배열을 출력
			for(int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
		}
		for(int i = 1; i <= N; i++) {
			// 선택여부가 false면 실행
			if(!isSelected[i]) {
				// i번째 선택된 숫자를 i번째 배열에 할당
				numbers[cnt] = i;
				// 배열에 넣었으니 해당 숫자의 선택여부 true
				isSelected[i] = true;
				// 다음 숫자 선택
				permutation(cnt+1);
				// 마지막 숫자까지 선택 후 돌아와서 선택여부 false
				isSelected[i] = false;
				
			}
		}
	}
}