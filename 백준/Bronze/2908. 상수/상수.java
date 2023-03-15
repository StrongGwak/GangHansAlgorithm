import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        String ac = "";
        String bc = "";
        for(int i = 2; i >= 0; i--){
            ac += a.charAt(i);
            bc += b.charAt(i);
        }
        int an = Integer.parseInt(ac);
        int bn = Integer.parseInt(bc);

        if(an > bn) {
            System.out.println(an);
        } else {
            System.out.println(bn);
        }
    }
}