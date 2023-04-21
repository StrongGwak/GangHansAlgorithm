import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());
		int count = 0;
		
		while(N >= 5) {
			count += N/5;
			N /= 5;
		}
		System.out.println(count);
	}
}