import java.util.*;
import java.io.*;

class Q2920_기본문제 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = "";
        for (int i = 0; i < 8; i++) {
            input += st.nextToken();
        }

        int toInt = Integer.parseInt(input);
        if (toInt == 12345678) System.out.print("ascending");
        else if (toInt == 87654321) System.out.print("descending");
        else System.out.print("mixed");
    }
}
