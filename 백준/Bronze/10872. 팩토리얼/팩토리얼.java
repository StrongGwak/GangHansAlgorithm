import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fact(N));
	}
	
	public static int fact(int num) {
		if(num <= 1) {
			return 1;
		}
		return fact(num - 1) * num;
	}
}