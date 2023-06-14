import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static  class Top {
		int index, height;
		
		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	static int N, index;
	static int[] top;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Top> s = new Stack<>();
		// N 탑의 수
		N = parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		// 탑 할당
		for(int i = 1; i <= N; i++) {
			int a = parseInt(st.nextToken());
			if(s.isEmpty()) {
				sb.append(0).append(' ');
				s.push(new Top(i, a));
			} else {
				while(true) {
					if(s.isEmpty()) {
						sb.append(0).append(' ');
						s.push(new Top(i, a));
						break;
					}
					
					if(s.peek().height > a) {
						sb.append(s.peek().index).append(' ');
						s.push(new Top(i, a));
						break;
					} else {
						s.pop();
					}
				}
			}
		}
		System.out.print(sb);
	}
}