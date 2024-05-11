import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            String s = sc.next();
            int upper = 0, lower = 0, digit = 0;
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                if('A' <= c && c <= 'Z') upper++;
                if('a' <= c && c <= 'z') lower++;
                if('0' <= c && c <= '9') digit++;
            }
            if(upper <= lower && s.length() <= 10 && digit < s.length()){
                System.out.println(s);
            }
        }
        sc.close();
    }
}