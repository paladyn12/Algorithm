import java.util.*;
import java.io.*;

class Q1259_문자열 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        while (!N.equals("0")) {
            boolean success = true;
            int size = N.length() - 1;
            
            for (int i = 0; i < size; i++) {
                if (N.charAt(i) != N.charAt(size - i)) success = false;
            }

            if (success) sb.append("yes\n");
            else sb.append("no\n");
            N = br.readLine();
        }
        System.out.print(sb);
    }
}
