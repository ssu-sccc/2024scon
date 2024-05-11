import java.util.Scanner;

public class Main{
    static char check(StringBuilder s){
        boolean res = s.charAt(0) == 'T';
        for(int i=2; i<s.length(); i+=2){
            if(s.charAt(i-1) == '&') res = res & (s.charAt(i) == 'T');
            else res = res | (s.charAt(i) == 'T');
        }
        return res ? 'T' : 'F';
    }

    static void flip(StringBuilder s, int i){
        if(s.charAt(i) == 'T') s.setCharAt(i, 'F');
        else if(s.charAt(i) == 'F') s.setCharAt(i, 'T');
        else if(s.charAt(i) == '&') s.setCharAt(i, '|');
        else s.setCharAt(i, '&');
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder s = new StringBuilder();
        for(int i=0; i<n; i++) s.append(sc.next().charAt(0));
        char c = sc.next().charAt(0);
        if(check(s) == c){ System.out.println(0); return; }

        for(int i=0; i<n; i++){
            flip(s, i);
            if(check(s) == c){ System.out.println(1); return; }
            flip(s, i);
        }
        
        System.out.println(2);
    }
}
