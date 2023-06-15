import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int meet, max, prev;
	static int[][] time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		meet = Integer.parseInt(st.nextToken());
		time = new int[meet][2];
		for(int i = 0; i < meet; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		// 끝나는 시간 오름차순으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		for(int i = 0; i < meet; i++) {
			// 시작 시간이 이전 회의 끝나는 시간보다 크거나 같다면
			if(prev <= time[i][0]) {
				prev = time[i][1];
				max++;
			}
		}
		System.out.println(max);
	}
	
}