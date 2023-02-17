import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 5킬로그램 봉지 수
		int f = 0;
		// 3킬로그램 봉지 수
		int t = 0;
		// 남은 설탕
		int s = 0;
		// 5킬로그램에 모두 담았을 때 남는 설탕
		s = N % 5;
		// 담은 5킬로그램 봉지
		f = N / 5;
		// 남은 설탕에 5킬로봉지 설탕을 다시 부어서 3킬로그램 봉지로 나눠담아
		// 남은 설탕없이 다 담을 수 있는지 확인
		while(s <= N) {
			if(s % 3 == 0) {
				t = s / 3;
				break;
			}
			s += 5;
			f--;
		}
		// 담을 수 없으면 -1
		if((f+t) <= 0) {
			System.out.println(-1);
		} else { // 담았다면 봉지 수 출력
			System.out.println(f + t);
		}
	}
}