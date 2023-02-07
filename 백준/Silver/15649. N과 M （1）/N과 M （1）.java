import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int[] num;
	static boolean[] isSelect;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 선택 할 숫자의 개수
		num = new int[m];
		// 중복여부를 체크
		isSelect = new boolean[n];
		
		mn(0);
		System.out.println(sb);
		
		
	}
	
	public static void mn(int count) {
		// 뽑을 갯수와 뽑은 갯수가 같다면
		if(count == m) {
			// 뽑은 수들을 스트링빌더에 append
			for(int val : num) {
				sb.append(val).append(' ');
			}
			//줄바꿈
			sb.append('\n');
			return;
		}
		// 할당 할 숫자 1부터 n까지
		for(int i = 0; i < n; i++) {
			// 선택이 안됐다면
			if(!isSelect[i]) {
				//선택 체크
				isSelect[i] = true;
				//뽑을 숫자 배열에 숫자 할당
				num[count] = i + 1;
				// 뽑았으니 다음 수 뽑기위해 count에 +1
				mn(count + 1);
				// 뽑고 난 후 false
				isSelect[i] = false;
			}
			
		}
	}
	
	

}