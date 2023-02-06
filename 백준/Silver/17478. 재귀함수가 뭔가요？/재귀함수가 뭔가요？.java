import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 재귀횟수 입력받기
		int N = Integer.parseInt(br.readLine());
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		//재귀함수 호출
		recursion(N, N);
	}
	
	// n은 변동, a는 고정
	public static void recursion(int n, int a) {
		String s = "";
		// 반복할수록 ____ 추가
		for(int i = n; i < a; i++) {
			s += "____";
		}
		if(n == 0) {
			System.out.println(s + "\"재귀함수가 뭔가요?\"");
			System.out.println(s + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			// 라고 답변하였지는 마지막에 반복하며 출력
			for(int i = n; i <= a; i++) {
				for(int j = i; j < a; j++) {
					System.out.print("____");
				}
				System.out.println("라고 답변하였지.");
			}
		} else {
			System.out.println(s+"\"재귀함수가 뭔가요?\"");
			System.out.println(s+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(s+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(s+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			recursion(n - 1, a);
		}
		
		
	}

}