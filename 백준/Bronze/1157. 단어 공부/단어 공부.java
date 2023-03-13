import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine().toUpperCase();
        int[] nums = new int[91];
        int max = 0;
        int maxIndex = 0;
        int maxNums = 0;
        for(int i = 0; i < a.length(); i++){
            nums[a.charAt(i)]++;
        }
        for(int i = 65; i <= 90; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        for(int i = 65; i <= 90; i++){
            if(max == nums[i]){
                maxNums++;
            }
        }
        if(maxNums > 1){
            System.out.println("?");
        } else {
            System.out.println((char)maxIndex);
        }

    }
}