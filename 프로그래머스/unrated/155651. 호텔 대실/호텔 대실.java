import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
class Solution {
    public int solution(String[][] book_time) {
        // 빠른 시간순으로 정렬
        sort(book_time);
        int[][] times;
        
        // String to Integer 변환
        times = tran(book_time);
        
        // 최소한의 객실 구하기
        int answer = reservation(times);
        return answer;
    }
    
    public int reservation(int[][] times) {
        // 방 ArrayList
        ArrayList<Integer> room = new ArrayList<Integer>();
        // 첫 손님 방의 퇴실 시간 할당
        room.add(times[0][1]);
        // 두번째 손님부터 반복
        for(int i = 1; i < times.length; i++) {
            // 예약된 방의 수 만큼 반복
            for(int j = 0; j < room.size(); j++) {
                // 예약된 방의 퇴실 시간 + 청소시간 보다 크거나 같으면 
                // 다음 손님의 퇴실 시간을 그 방에 할당 후 반복 종료
                if(room.get(j) <= times[i][0]) {
                    room.set(j,times[i][1]);
                    break;
                // 마지막 방까지 확인 했으면 새로운 방에 할당
                } else if(j == room.size() - 1) {
                    room.add(times[i][1]);
                    break;
                }
            }
        }
        return room.size();
        
    }
    
    public String[][] sort(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].toString().compareTo(o2[0].toString());
            }
        });
        return book_time;
    }
    
    public int[][] tran(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            String[] strStart = book_time[i][0].split(":");
            String[] strEnd = book_time[i][1].split(":");
            times[i][0] = Integer.parseInt(strStart[0]) * 60 + Integer.parseInt(strStart[1]);
            times[i][1] = Integer.parseInt(strEnd[0]) * 60 + Integer.parseInt(strEnd[1]) + 10;
        }
        
        return times;
    }
}
