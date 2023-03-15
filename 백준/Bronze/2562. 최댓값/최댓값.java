import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < 9; i++){
            nums[i] = Integer.parseInt(br.readLine());
            if(max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex+1);
    }
}