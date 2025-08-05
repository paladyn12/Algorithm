import java.util.*;
import java.io.*;

class Q14626_수학 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        int cnt = 0;
        boolean multi3 = false;
        for (int i = 0; i < 12; i++) {
            if (N.charAt(i) == '*') {
                if (i % 2 == 1) multi3 = true;
            } else {
                if (i % 2 == 0) cnt += N.charAt(i) - '0';
                else cnt += (N.charAt(i) - '0') * 3;
            }
        }
        cnt = (cnt + 9) % 10 + 1;
        int check = N.charAt(12) - '0';

        int result = 0;
        if (multi3) {
            while ((cnt + 3 * result + 9) % 10 + 1 != 10 - check) result++;
            
        } else {
            while ((cnt + result + 9) % 10 + 1 != 10 - check) result++;
        }
        
        System.out.print(result);
    }
}
