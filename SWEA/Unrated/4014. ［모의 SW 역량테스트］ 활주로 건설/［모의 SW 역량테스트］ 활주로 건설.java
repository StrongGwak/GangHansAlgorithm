import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	public static class Node {
		int length, height;
		
		Node(int length, int height){
			this.length = length;
			this.height = height;
		}
	}

	static int T, N, X, map[][], result;
	static ArrayList<ArrayList<Node>> list;
	static ArrayList<Node> nl;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			result = 0;
			N = parseInt(st.nextToken());
			X = parseInt(st.nextToken());
			list = new ArrayList<ArrayList<Node>>();
			for(int i = 0; i < N*2; i++) {
				list.add(new ArrayList<Node>());
			}
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = parseInt(st.nextToken()); 
				}
			}
			info();
			for(int i = 0; i < N*2; i++) {
				for(int j = 0; j < list.get(i).size(); j++) {
					if(j == list.get(i).size()-1) {
						result++;
					} else if(list.get(i).get(j+1).height - list.get(i).get(j).height == 1) {
						if(list.get(i).get(j).length < X) {
							break;
						}
					} else if (list.get(i).get(j+1).height - list.get(i).get(j).height == -1) {
						if(list.get(i).get(j+1).length < X) {
							break;
						} else {
							list.get(i).get(j+1).length -= X;
						}
					} else {
						break;
					}
				}
			}
			
			
			
			sb.append('#').append(tc).append(' ').append(result).append('\n');
		}
		System.out.println(sb);

	}
	
	public static void info() {
		int count = 1;
		for(int i = 0; i < N; i++) {
			count = 1;
			for(int j = 0; j < N-1; j++) {
				if(map[i][j] == map[i][j+1]) {
					count++;
				} else {
					list.get(i).add(new Node(count, map[i][j]));
					count = 1;
				}
			}
			list.get(i).add(new Node(count, map[i][N-1]));
		}
		for(int i = 0; i < N; i++) {
			count = 1;
			for(int j = 0; j < N-1; j++) {
				if(map[j][i] == map[j+1][i]) {
					count++;
				} else {
					list.get(i+N).add(new Node(count, map[j][i]));
					count = 1;
				}
			}
			list.get(i+N).add(new Node(count, map[N-1][i]));
		}
	}

}