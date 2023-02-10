import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] height, numbers;
	static int sum;
	static boolean find;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		// 9명의 키
		height = new int[9];
		// 진짜 일곱 난쟁이 배열
		numbers = new int[7];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			height[i] = Integer.parseInt(st.nextToken());
		}
		// 조합 시작
		combination(0,0);
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int start) {
		// 7명을 다 뽑으면 실행 0부터 시작이라 7이면 재귀종료
		if(cnt == 7) {
			// 합 초기화
			sum = 0;
			// 7명의 키를 합한다.
			for(int i = 0; i < numbers.length; i++ ) {
				sum += numbers[i];
			}
			// 만약 합이 100과 같거나 작고 찾은적이 없다면 시작
			if(sum == 100 && !find) {
				// 찾았으니 오름차순 정렬
				for(int i = 0; i < numbers.length; i++) {
					for(int j = i; j < numbers.length; j++) {
						if(numbers[i] > numbers[j]) {
							int tmp = numbers[i];
							numbers[i] = numbers[j];
							numbers[j] = tmp;
						}
					}
				}
				// 오름차순으로 출력
				for(int i = 0; i < numbers.length; i++ ) {
					sb.append(numbers[i]).append("\n");
				}
				// 결과가 여러개면 아무거나 출력하라고 했으니 찾으면 더이상 출력하지않게 한다.
				find = true;
			}
			return;
		}
		// 9명중 7명을 뽑아서 확인
		for(int i = start; i < 9; i++) {
			// 7명을 순서대로 할당
			numbers[cnt] = height[i];
			// 뽑고나면 1 더해줘서 다음 난쟁이를 뽑는다.
			combination(cnt + 1, i + 1);
		}
	}
}