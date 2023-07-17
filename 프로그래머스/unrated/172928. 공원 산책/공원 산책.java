class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int parkHeight = park.length;
        int parkWidth = park[0].length();
        boolean[][] map = new boolean[parkHeight][parkWidth];
        for(int i = 0; i < parkHeight; i++) {
            String parkLine = park[i];
            for(int j = 0; j < parkWidth; j++) {
                if(parkLine.charAt(j) == 'X') {
                    map[i][j] = true;
                } else if (parkLine.charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            String route = routes[i];
            int way = wayCheck(route.charAt(0));
            int range = route.charAt(2) - 48;
            answer = check(answer, way, range, map);
        }
        
        return answer;
    }
    
    public static int wayCheck(char way) {
        if(way == 'N') {
            return 0;
        } else if (way == 'E') {
            return 1;
        } else if (way == 'S') {
            return 2;
        } else{
            return 3;
        }
    }
    
    public static int[] check(int[] answer, int way, int range, boolean[][] map) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int mx = answer[0];
        int my = answer[1];
        for(int i = 0; i < range; i++) {
            mx += dx[way];
            my += dy[way];
            if(mx < 0 || mx >= map.length || my < 0 || my >= map[0].length || map[mx][my]) {
                return answer;
            }
        }
        answer[0] = mx;
        answer[1] = my;
        return answer;
    }
    
    
}