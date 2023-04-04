import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution {

	static int T, D, W, K, film[][], shot, num[], m[], copy[][];
	static boolean s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T =  parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = parseInt(st.nextToken());
			W = parseInt(st.nextToken());
			K = parseInt(st.nextToken());
			film = new int[D][W];
			copy = new int[D][W];
			s = false;
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					copy[i][j] = film[i][j] = parseInt(st.nextToken());
				}
			}
			if(K==1 || check()) {
				sb.append('#').append(test_case).append(' ').append(0).append('\n');
			} else {
				shot = 1;
				num = new int[D];
				for(int i = shot; i <= K; i++) {
					m = new int[shot];
					if(line(0,0)) {
						sb.append('#').append(test_case).append(' ').append(shot).append('\n');
						break;
					} else {
						shot++;
					}
				}
			}
		}
		System.out.println(sb);
	}
	
	public static boolean check() {
		for(int i = 0; i < W; i++) {
			boolean c = false;
			for(int j = 0; j <= D-K; j++) {
				int sum = 0;
				for(int k = 0; k < K; k++) {
					sum += copy[j+k][i];
				}
				if(sum == 0 || sum == K) {
					c = true;
					break;
				}
			}
			if(!c) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean line(int start, int cnt) {
		if(cnt == shot) {
			return medicine(0);
		}
		
		for(int i = start; i < D; i++) {
			num[cnt] = i;
			line(i+1, cnt+1);
		}
		return s;
	}
	
	public static boolean medicine(int cnt) {
		if(s) {
			return s;
		}
		if(cnt == shot) {
			for(int i = 0; i < D; i++) {
				copy[i] = Arrays.copyOf(film[i], W);
			}
			for(int i = 0; i < shot; i++) {
				for(int j = 0; j < W; j++) {
					copy[num[i]][j] = m[i];
				}
			}
			
			s = check();
			return s;
		}
		
		for(int i = 0; i < 2; i++) {
			m[cnt] = i;
			medicine(cnt+1);
		}
		return false;
	}
}