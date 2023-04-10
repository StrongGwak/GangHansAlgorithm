import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Solution {

	static int T, N, map[][], fNum[], sNum[], fSum, sSum, min, f[], s[];
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine().trim());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken());
				}
			}
			isSelected = new boolean[N];
			// 처음 요리 재료
			fNum = new int[N / 2];
			f = new int[2];
			// 두번째 요리
			sNum = new int[N / 2];
			s = new int[2];
			min = Integer.MAX_VALUE;
			pick(0, 0);
			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.println(sb);

	}

	public static void pick(int cnt, int start) {
		if (cnt == N / 2) {
			fSum = sSum = 0;
			int fn = 0;
			int sn = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					fNum[fn++] = i;
				}
			}
			for (int i = 0; i < N; i++) {
				if (!isSelected[i]) {
					sNum[sn++] = i;
				}
			}
			secondPick(0, 0);
			thirdPick(0, 0);
			int value = Math.abs(fSum - sSum);
			if (min > value) {
				min = value;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				pick(cnt + 1, i + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void secondPick(int cnt, int start) {
		if (cnt == 2) {
			int a = map[f[0]][f[1]] + map[f[1]][f[0]];
			fSum += a;
			return;
		}
		for (int i = start; i < N / 2; i++) {
			f[cnt] = fNum[i];
			secondPick(cnt + 1, i + 1);
		}
	}

	public static void thirdPick(int cnt, int start) {
		if (cnt == 2) {
			int a = map[s[0]][s[1]] + map[s[1]][s[0]];
			sSum += a;
			return;
		}
		for (int i = start; i < N / 2; i++) {
			s[cnt] = sNum[i];
			thirdPick(cnt + 1, i + 1);
		}
	}

}