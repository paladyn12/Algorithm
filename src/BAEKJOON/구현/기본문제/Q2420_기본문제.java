import java.util.*;
import java.io.*;

class Q2420_기본문제 {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long n1 = Long.parseLong(st.nextToken());
        Long n2 = Long.parseLong(st.nextToken());

        System.out.print(Math.abs(n1 - n2));
    }
}
