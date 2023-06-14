import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sNum, student;
	static boolean status[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sNum = parseInt(br.readLine());
		status = new boolean[sNum+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= sNum; i++) {
			if(parseInt(st.nextToken())==1) {
				status[i] = true;
			}
		}
		
		student = parseInt(br.readLine());

		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());
			
			if(a == 1) {
				boy(b);
			} else {
				girl(b);
			}
		}
		
		for(int i = 1; i <= sNum; i++) {
			if(status[i]) {
				sb.append(1).append(' ');
			} else {
				sb.append(0).append(' ');
			}
			if(i%20==0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
		
	}
	
	public static void girl(int index) {
		int n = 1;
		if(status[index]) {
			status[index] = false;
		} else {
			status[index] = true;
		}
		while(index-n >= 1 && index+n <= sNum) {
			if(status[index-n] == status[index+n]) {
				if(status[index-n]) {
					status[index-n] = false;
					status[index+n] = false;
				} else {
					status[index-n] = true;
					status[index+n] = true;
				}
			} else {
				break;
			}
			n++;
		}
	}
	
	public static void boy(int index) {
		int i = index;
		while(i <= sNum) {
			if(status[i]) {
				status[i] = false;
			} else {
				status[i] = true;
			}
			i += index;
		}
	}
}