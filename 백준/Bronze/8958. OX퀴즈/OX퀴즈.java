import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++){
			int o = 1;
			int result = 0;
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++){
				if(str.charAt(j) == 'O'){
					result += o;
					o++;
				} else {
					o = 1;
				}
			}
			System.out.println(result);
		}
	}
}