import java.io.*;
import java.util.*;

public class Q15961_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cntArray = new int[d + 1];
        int[] belt = new int[k];
        int[] first = new int[k];

        int max = 0;
        int current = 0;
        for (int i = 0; i < N + k; i++) {
            
            if (belt[i % k] != 0) {
                cntArray[belt[i % k]]--;
                if (cntArray[belt[i % k]] == 0) current--;
            }

            if (i >= N) belt[i % k] = first[i - N];
            else belt[i % k] = Integer.parseInt(br.readLine());
            if (i < k) first[i] = belt[i % k];
            
            cntArray[belt[i % k]]++;
            if (cntArray[belt[i % k]] == 1) current++;

            if (cntArray[c] == 0) max = Math.max(max, current + 1);
            else max = Math.max(max, current);

        }
        System.out.print(max);
    }
}
