import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 재료의 개수
	static int min; // 차이가 가장 작은 값
	static int[] bitter, sour; // 쓴맛과 신맛
	static boolean[] isSelected; // 각 원소가 부분집합의 구성에 포함되었는지 여부

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//재료의 개수 입력
		N = Integer.parseInt(st.nextToken());
		//최솟값 설정
		min = Integer.MAX_VALUE;
		// 신맛 배열 생성
		sour = new int[N];
		// 쓴맛 배열 생성
		bitter = new int[N];
		// 포함 여부 배열 생성
		isSelected = new boolean[N];
		// 재료의 개수만큼 반복하여 신맛 쓴맛 값을 배열에 할당
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		generateSubSet(0,0,1);
		System.out.println(min);

	}

	public static void generateSubSet(int cnt, int sum, int mul) {// cnt : 직전까지 고려한 원소수
																			  // sum = 직전까지 선택된 원소들의 합
																		      // mul = 직전까지 선택된 원소들의 곱
		if (cnt == N) {
			//신맛과 쓴맛의 차이가 min보다 작으면 그 값을 min에 할당
			if(sum > 0 && Math.abs(sum - mul) < min) {
				min = Math.abs(sum - mul);
			}
			return;

		} else {
			// 현재 원소를 부분집합의 구성에 포함
			isSelected[cnt] = true;
			generateSubSet(cnt + 1, sum + bitter[cnt], mul * sour[cnt]);
			// 현재 원소를 부분집합의 구성에 비포함
			isSelected[cnt] = false;
			generateSubSet(cnt + 1, sum, mul);

		}
	}

}
