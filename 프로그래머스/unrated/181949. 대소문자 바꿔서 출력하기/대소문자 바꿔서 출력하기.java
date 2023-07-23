import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i = 0; i < a.length(); i++){
            
            if((int)a.charAt(i) <= 90){
                String str = Character.toString(a.charAt(i)).toLowerCase();
                System.out.print(str);
            } else {
                String str = Character.toString(a.charAt(i)).toUpperCase();
                System.out.print(str);
            }
        }
    }
}