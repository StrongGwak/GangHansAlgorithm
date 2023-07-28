import java.util.ArrayDeque;
class Solution {
    public class Node {
        int x; 
        int y; 
        int lever;
        int move;
        
        public Node(int x, int y, int lever, int move) {
            this.x = x;
            this.y = y;
            this.lever = lever;
            this.move = move;
        }
    }
    
    public int solution(String[] maps) {
        // 맵 2차원 배열 생성
        String[][] map = new String[maps.length][maps[0].length()];
        // 시작 좌표
        int startX = 0;
        int startY = 0;
        // 맵 2차원 배열로 분리
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
            // 시작 좌표 구하기
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int answer = move(map, new Node(startX, startY, 0, 0));
        return answer;
    }
    
    public int move(String[][] map, Node node) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // mapLength [0] = 열 크기 , [1] = 행 크기
        int[] mapLength = {map.length, map[0].length};
        boolean[][][] visited = new boolean[mapLength[0]][mapLength[1]][2];
        ArrayDeque<Node> action = new ArrayDeque<Node>();
        action.add(node);
        visited[node.x][node.y][node.lever] = true;
        
        while (!action.isEmpty()) {
            Node human = action.poll();
            for (int i = 0; i < 4; i++) {
                int mx = human.x + dx[i];
                int my = human.y + dy[i];
                if (mx >= 0 && mx < mapLength[0] && my >= 0 && my < mapLength[1] && 
                    !visited[mx][my][human.lever] && !map[mx][my].equals("X")) {
                    if (human.lever == 0 && map[mx][my].equals("L")) {
                        action.add(new Node(mx, my, 1, human.move + 1));
                        visited[mx][my][human.lever] = true;
                    } else if (map[mx][my].equals("E") && human.lever == 1) {
                        return human.move + 1;
                    } else {
                        action.add(new Node(mx, my, human.lever, human.move + 1));
                        visited[mx][my][human.lever] = true;
                    }
                }
            }
        }
        return -1;
    }
}