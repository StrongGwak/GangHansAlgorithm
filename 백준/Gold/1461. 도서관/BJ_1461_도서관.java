package boj;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1461_도서관 {
	static int N, M, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N 책의 수
		N = parseInt(st.nextToken());
		// M 운반 가능 책의 수
		M = parseInt(st.nextToken());
		// 음수 책 위치 큐
		PriorityQueue<Integer> neg = new PriorityQueue<Integer>();
		// 양수 책 위치 큐
		PriorityQueue<Integer> pos = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int a = parseInt(st.nextToken());
			if(a > 0) {
				pos.add(a);
			} else {
				neg.add(a);
			}
		}
		
		// 절대값이 가장 큰 수는 마지막에 놓아야 함
		if(!pos.isEmpty() && !neg.isEmpty()) {
			if(pos.peek() > Math.abs(neg.peek())) {
				result = pos.poll();
				for(int i = 1; i < M; i++) {
					if(!pos.isEmpty()) {
						pos.remove();
					}
				}
			} else {
				result = Math.abs(neg.poll());
				for(int i = 1; i < M; i++) {
					if(!neg.isEmpty()) {
						neg.remove();
					}
				}
			}
		} else if (!pos.isEmpty()) {
			result = pos.poll();
			for(int i = 1; i < M; i++) {
				if(!pos.isEmpty()) {
					pos.remove();
				}
			}
		} else {
			result = Math.abs(neg.poll());
			for(int i = 1; i < M; i++) {
				if(!neg.isEmpty()) {
					neg.remove();
				}
			}
		}
		
		
		// 나머지 책 운반
		while(!pos.isEmpty()) {
			result += pos.poll() * 2;
			for(int i = 1; i < M; i++) {
				if(!pos.isEmpty()) {
					pos.remove();
				}
			}
		}
		
		while(!neg.isEmpty()) {
			result += Math.abs(neg.poll()) * 2;
			for(int i = 1; i < M; i++) {
				if(!neg.isEmpty()) {
					neg.remove();
				}
			}
		}
		
		System.out.println(result);
	}

}
