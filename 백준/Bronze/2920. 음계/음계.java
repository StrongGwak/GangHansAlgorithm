import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ascending = 1;
        int descending = 8;
        int[] nums = new int[8];
        for(int i = 0; i < 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if(nums[i] == ascending){
                ascending++;
            }
            if (nums[i] == descending){
                descending--;
            }
        }

        if(ascending == 9){
            System.out.println("ascending");
        } else if (descending == 0) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}