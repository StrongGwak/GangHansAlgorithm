import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
		int[] num = new int[s.length];
		int tmp = 0;
        for(int i = 0; i < s.length; i++) {
        	num[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0; i < s.length; i++) {
        	for(int j = i + 1; j < s.length; j++) {
        		if(num[i] > num[j]) {
        			tmp = num[i];
        			num[i] = num[j];
        			num[j] = tmp;
        		}
        	}
        	if(i != s.length - 1) {
        		System.out.print(num[i] + " ");
        	} else {
        		System.out.println(num[i]);
        	}
        }
    }
}