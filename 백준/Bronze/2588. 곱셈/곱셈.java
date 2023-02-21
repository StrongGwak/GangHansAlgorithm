import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		int b1 = b.charAt(0) - 48;
		int b2 = b.charAt(1) - 48;
		int b3 = b.charAt(2) - 48;
		System.out.println(a * b3);
		System.out.println(a * b2);
		System.out.println(a * b1);
		System.out.println((a * b3) + (a * b2 * 10) + (a * b1 * 100));
	}
}