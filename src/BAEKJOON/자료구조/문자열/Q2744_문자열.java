import java.util.*;
import java.io.*;

class Q2744_문자열 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a') result += (char) (c - 32);
            else result += (char) (c + 32);
        }

        System.out.print(result);
    }
}
