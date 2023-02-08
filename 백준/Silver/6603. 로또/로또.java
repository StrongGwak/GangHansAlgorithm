import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int k;
	static int[] num, lotto;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//마지막 줄에 0이 주어진다했으니 k가 0이면 마지막
		do {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			//뽑을 6자리 수의 배열
			lotto = new int[6];
			//정해진 k개의 숫자 배열
			num = new int[k];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);
			System.out.println();
		} while(k != 0);
	}

	// cnt는 자릿수, start는 중복없이 하기 위한 수
	public static void combination(int cnt, int start) {
		// 6자리 수를 뽑아야하기 때문에 조건은 cnt == 6 일때 뽑은 숫자 출력
		if (cnt == 6) {
			for (int i = 0; i < lotto.length; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < k; i++) {
			//로또 배열 자릿수에 뽑은 숫자 할당
			lotto[cnt] = num[i];
			// 중복을 없애기 위해선 현재보다 뒤에있는 배열을 뽑아야한다.
			combination(cnt + 1, i + 1);
		}
	}

}
