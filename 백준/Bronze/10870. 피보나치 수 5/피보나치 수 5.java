import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(N));
	}
	
	public static int fibonacci(int num) {
		if(num <= 1) {
			return num;
		}
		//피보나치수 num은 피보나치수 num-1과 num-2의 수를 합한것과 같기때문에 1까지 재귀함수를 호출하여 더하면 N번째 피보나치수를 구할 수 있다.
		return fibonacci(num-1) + fibonacci(num-2);
	}

}