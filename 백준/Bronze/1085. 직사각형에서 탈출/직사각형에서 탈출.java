import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = parseInt(st.nextToken());
		int y = parseInt(st.nextToken());
		int w = parseInt(st.nextToken());
		int h = parseInt(st.nextToken());
		int minX = 0, minY = 0;
		if(x < (w-x)) {
			minX = x;
		} else {
			minX = w-x;
		}
		if(y < (h-y)) {
			minY = y;
		} else {
			minY = h-y;
		}
		if(minX < minY) {
			System.out.println(minX);
		} else {
			System.out.println(minY);
		}
	}
}