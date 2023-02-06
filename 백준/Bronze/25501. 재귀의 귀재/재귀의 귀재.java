import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int result = isPalindrome(br.readLine());
			// 양수의 count 면 팰린드롬이 맞기 때문에 1과 count수 출력
			if(result > 0) {
				System.out.println("1 " + result );
			// 음수의 count 면 팰린드롬이 아니기 때문에 0과 count수 출력
			} else {
				//abs를 통해서 양수로 바꿔주기
				System.out.println("0 " + Math.abs(result));
			}
		}
	}
	
	public static int recursion(String s, int l, int r, int count){
		//맨 앞과 맨 끝에서 조회하다가 자릿수가 같아지면 양수 count 리턴
        if(l >= r) return count;
        // 글자가 다르면 팰린드롬이 아니기에 음수 count 리턴
        else if(s.charAt(l) != s.charAt(r)) return -count;
        //글자가 같으면 재귀함수 호출 count 증가
        else return recursion(s, l+1, r-1, count+1);
    }
	
    public static int isPalindrome(String s){
    	// 팰린드롬 검사
        return recursion(s, 0, s.length()-1,1);
    }

}