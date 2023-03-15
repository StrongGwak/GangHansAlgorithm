import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int repeat = parseInt(st.nextToken());
            String str = st.nextToken();
            for(int i = 0; i < str.length(); i++){
                for(int j = 0; j < repeat; j++){
                    sb.append(str.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}