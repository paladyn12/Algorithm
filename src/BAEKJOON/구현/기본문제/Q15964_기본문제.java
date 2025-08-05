import java.util.*;
import java.io.*;

class Q15964_기본문제 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());

        Long result = (n1 + n2) * (n1 - n2);

        System.out.print(result);
    }
}
