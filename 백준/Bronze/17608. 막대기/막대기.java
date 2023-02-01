import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stick = new int[N];
		int lookStick = 0; 
		int maxHeight = Integer.MIN_VALUE;
		for(int i = 0; i < stick.length; i++) {
			stick[i] = Integer.parseInt(br.readLine());
		}
		for(int i = stick.length-1; i >= 0; i--) {
			if(stick[i] > maxHeight) {
				maxHeight = stick[i];
				lookStick++;
			}
		}
		System.out.println(lookStick);
	}
}