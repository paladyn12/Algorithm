import java.util.*;
import java.io.*;

class Q2754_기본문제 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char alpha = str.charAt(0);
        if (alpha == 'F') {
            System.out.print(0.0);
            return;
        }
        char add = str.charAt(1);

        double result = 0.0;
        
        switch (alpha) {
            case 'A':
                result += 4;
                break;
            case 'B':
                result += 3;
                break;
            case 'C':
                result += 2;
                break;
            case 'D':
                result += 1;
                break;
        }

        switch (add) {
            case '+':
                result += 0.3;
                break;
            case '0':
                break;
            case '-':
                result -= 0.3;
                break;
        }

        System.out.print(result);
    }
}
