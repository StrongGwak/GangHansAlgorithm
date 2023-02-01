import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		while(list.size() > 1) {
			System.out.print(list.get(0) + " ");
			list.remove(0);
			list.add(list.get(0));
			list.remove(0);
		}
		System.out.print(list.get(0));
	}

}