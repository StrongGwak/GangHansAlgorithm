import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= N; test_case++) {
			String[] s = br.readLine().split(" ");
			System.out.print("Case #" + test_case + ": ");
			for(int i = s.length-1; i >= 0; i--) {
				if(i != 0) {
					System.out.print(s[i] + " ");
				} else {
					System.out.print(s[i]);
				}
			}
			System.out.println();
		}
	}
}