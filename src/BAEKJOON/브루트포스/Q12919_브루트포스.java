import java.io.*;
import java.util.*;

public class Q12919_브루트포스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        sb.append(S).reverse();
        String reverseS = sb.toString();
        String T = br.readLine();

        boolean success = false;
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.addLast(T);
        while (!dq.isEmpty()) {
            String cur = dq.pollFirst();
            if (cur.equals(S)) {
                success = true;
                break;
            }
            if (cur.charAt(cur.length() - 1) == 'A') {
                String s1 = cur.substring(0, cur.length() - 1);
                if (s1.contains(S) || s1.contains(reverseS)) dq.addLast(s1);
            }
            if (cur.charAt(0) == 'B') {
            	sb = new StringBuilder();
            	String s2 = sb.append(cur.substring(1, cur.length())).reverse().toString();
                if (s2.contains(S) || s2.contains(reverseS)) dq.addLast(s2ㅁmport java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        sb.append(S).reverse();
        String reverseS = sb.toString();
        String T = br.readLine();

        boolean success = false;
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.addLast(T);
        while (!dq.isEmpty()) {
            String cur = dq.pollFirst();
            if (cur.equals(S)) {
                success = true;
                break;
            }
            if (cur.charAt(cur.length() - 1) == 'A') {
                String s1 = cur.substring(0, cur.length() - 1);
                if (s1.contains(S) || s1.contains(reverseS)) dq.addLast(s1);
            }
            if (cur.charAt(0) == 'B') {
            	sb = new StringBuilder();
            	String s2 = sb.append(cur.substring(1, cur.length())).reverse().toString();
                if (s2.contains(S) || s2.contains(reverseS)) dq.addLast(s2ㅁ);
            }
        }
        if (success) System.out.print(1);
        else System.out.print(0);
    }
}
