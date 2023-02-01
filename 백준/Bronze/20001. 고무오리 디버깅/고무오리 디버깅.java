import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int problem = 0;
		int duck = 0;
		String line = "";
		if(br.readLine().equals("고무오리 디버깅 시작")) {
			line = br.readLine();
			while(!line.equals("고무오리 디버깅 끝")) {
				if(line.equals("문제")) {
					problem++;
				} else if(line.equals("고무오리") && problem == 0) {
					problem += 2;
				} else if(line.equals("고무오리")) {
					problem--;
				}
				line = br.readLine();
			}
		}
		if(problem > 0) {
			System.out.println("힝구");
		} else {
			System.out.println("고무오리야 사랑해");
		}
	}
}