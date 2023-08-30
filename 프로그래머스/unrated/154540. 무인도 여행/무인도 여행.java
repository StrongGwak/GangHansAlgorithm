import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;

class Solution {
    public class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public ArrayList<Integer> solution(String[] maps) {
        
        int[][] map = setMaps(maps);
        
        return sumMeal(map);
    }
    
    public int[][] setMaps(String[] maps) {
        int x = maps.length;
        int y = maps[0].length();
        // 식량 수 나타내는 맵
        int[][] map = new int[x][y];
        // 문자열을 정수로 변환 바다면 방문 처리
        for (int i = 0; i < x; i++) {
            String[] str = maps[i].split("");
            for (int j = 0; j < y; j++) {
                if (str[j].equals("X")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
        }
        return map;
    }
    
    public ArrayList<Integer> sumMeal(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        ArrayList<Integer> answer = new ArrayList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
                if (!visited[i][j]) {
                    ArrayDeque<Node> q = new ArrayDeque<>();
                    int sum = 0;
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Node n = q.poll();
                        sum += map[n.x][n.y];
                        for (int k = 0; k < 4; k++) {
                            int mx = n.x + dx[k];
                            int my = n.y + dy[k];
                            if (mx >= 0 && mx < map.length && 
                                my >= 0 && my < map[i].length &&
                                map[mx][my] != 0 && !visited[mx][my]) {
                                visited[mx][my] = true;
                                q.add(new Node(mx, my));
                            }
                        }
                    }
                    answer.add(sum);
                }
            }
            
        }
        Collections.sort(answer);
        if(answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
    
}