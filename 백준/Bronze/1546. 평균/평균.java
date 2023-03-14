import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = parseInt(st.nextToken());
        double sum = 0;
        int max = 0;
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            nums[i] = parseInt(st.nextToken());
            if(nums[i] > max){
                max = nums[i];
            }
        }
        for(int i = 0; i < N; i++){
            sum += (double)nums[i]/max*100;
        }
        System.out.println((double)(sum/N));
    }
}