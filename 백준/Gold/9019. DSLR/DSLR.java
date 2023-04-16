import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int num;
		String root;

		public Node(int num, String root) {
			this.num = num;
			this.root = root;
		}
	}

	static int T, A, B;
	static String result;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = parseInt(st.nextToken());
			B = parseInt(st.nextToken());
			result = "";
			visited = new boolean[10000];
			DSLR(A);
			sb.append(result).append('\n');
		}
		System.out.println(sb);
	}

	public static void DSLR(int a) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(new Node(a, ""));
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.num == B) {
				result = n.root;
				return;
			}
			if(!visited[n.num]) {
				visited[n.num] = true;
				q.add(D(new Node(n.num, n.root)));
				q.add(S(new Node(n.num, n.root)));
				q.add(L(new Node(n.num, n.root)));
				q.add(R(new Node(n.num, n.root)));
			}
		}
	}

	public static Node D(Node n) {
		n.num *= 2;
		n.root += "D";
		if(n.num > 9999) {
			n.num %= 10000;
			return n;
		}
		return n;
	}

	public static Node S(Node n) {
		n.root += "S";
		if(n.num == 0) {
			n.num = 9999;
			return n;
		} else {
			n.num -= 1;
			return n;
		}
	}

	public static Node L(Node n) {
		int f = n.num/1000;
		n.num %= 1000;
		n.num *= 10;
		n.num += f;
		n.root += "L";
		return n;
	}

	public static Node R(Node n) {
		int l = (n.num % 10)*1000;
		n.num /= 10;
		n.num += l;
		n.root += "R";
		return n;
	}

}