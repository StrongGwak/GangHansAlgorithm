import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int score[][], match[][], able;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		// 4개의 결과
		for(int i = 0; i < 4; i++) {
			score = new int[6][3];
			match = new int[16][2];
			int m = 1;
			boolean five = true;
			able = 0;
			for(int j = 0; j < 6; j++) {
				for(int k = j+1; k < 6; k++) {
					match[m][0] = j;
					match[m++][1] = k;
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 6; j++) {
				score[j][0] = Integer.parseInt(st.nextToken());
				score[j][1] = Integer.parseInt(st.nextToken());
				score[j][2] = Integer.parseInt(st.nextToken());
				int sum = score[j][0]+score[j][1]+score[j][2];
				if(sum != 5) {
					five = false;
				}
			}
			if(five) {
				match(1);
			}
			sb.append(able).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void match(int num) { 
		if(!isAvailable(match[num-1][0], match[num-1][1])) {
			return;
		}
		
		if(num == 16) {
			able = 1;
			return;
		}
		// 팀1 승리 
		score[match[num][0]][0]--;
		score[match[num][1]][2]--;
		match(num + 1);
		score[match[num][0]][0]++;
		score[match[num][1]][2]++;
		// 팀1 무승부
		score[match[num][0]][1]--;
		score[match[num][1]][1]--;
		match(num + 1);
		score[match[num][0]][1]++;
		score[match[num][1]][1]++;
		// 팀1 패배
		score[match[num][0]][2]--;
		score[match[num][1]][0]--;
		match(num + 1);
		score[match[num][0]][2]++;
		score[match[num][1]][0]++;

	}

	private static boolean isAvailable(int h, int a) {
		if(score[h][0] < 0 || score[h][1] < 0 || score[h][2] < 0 || score[a][0] < 0 || score[a][1] < 0 || score[a][2] < 0) {
			return false;
		}
		return true;
	}
}