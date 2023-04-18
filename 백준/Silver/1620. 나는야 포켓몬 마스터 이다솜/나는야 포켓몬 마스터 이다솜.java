import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int have = parseInt(st.nextToken());
		int input = parseInt(st.nextToken());
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		String[] listArr = new String[have+1];
		for(int i = 1; i < have+1; i++) {
			String name = br.readLine();
			list.put(name, i);
			listArr[i] = name;
		}
		for(int i = 0; i < input; i++) {
			String in = br.readLine();
			boolean isNum = in.matches("[+-]?\\d*(\\.\\d+)?");
			if(isNum) {
				sb.append(listArr[parseInt(in)]).append('\n');
			} else {
				sb.append(list.get(in)).append('\n');
			}
		}
		System.out.println(sb);
	}
}