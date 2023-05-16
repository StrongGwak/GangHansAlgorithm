import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree> {
		int age;
		public Tree(int age) {
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	static int N, M, K, map[][], robot[][], energy[][], result;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static ArrayList<Tree> pq[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		K = parseInt(st.nextToken());
		map = new int[N][N];
		robot = new int[N][N];
		energy = new int[N][N];
		pq = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				robot[i][j] = parseInt(st.nextToken());
				pq[i][j] = new ArrayList<Tree>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = parseInt(st.nextToken()) - 1;
			int y = parseInt(st.nextToken()) - 1;
			int age = parseInt(st.nextToken());
			pq[x][y].add(new Tree(age));
		}
		
		for(int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				result += pq[i][j].size();
			}
		}
		
		System.out.println(result);

	}

	public static void spring() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(pq[i][j].size() > 0) {
					Collections.sort(pq[i][j]);
					int size = pq[i][j].size();
					for(int s = 0; s < size; s++) {
						int age = pq[i][j].get(s).age;
						if(map[i][j] >= age) {
							map[i][j] -= age;
							pq[i][j].set(s, new Tree(age+1));
						} else {
							energy[i][j] += age/2;
							pq[i][j].remove(s--);
							size--;
						}
					}
				}
			}
		}
	}

	public static void summer() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(energy[i][j] > 0) {
					map[i][j] += energy[i][j];
					energy[i][j] = 0;
				}
			}
		}
	}

	public static void fall() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(pq[i][j].size() > 0) {
					int size = pq[i][j].size();
					for(int s = 0; s < size; s++) {
						if(pq[i][j].get(s).age%5 == 0) {
							for(int k = 0; k < 8; k++) {
								int mx = i + dx[k];
								int my = j + dy[k];
								if(mx >= 0 && mx < N && my >= 0 && my < N) {
									pq[mx][my].add(new Tree(1));
								}
							}
						}
					}
				}
			}
		}
	}

	public static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] += robot[i][j];
			}
		}
	}

}