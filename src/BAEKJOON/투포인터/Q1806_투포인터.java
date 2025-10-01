import java.util.*;
import java.io.*;

class Q1806_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < N; end++) {
            sum += arr[end];
            while (sum >= S) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) System.out.print(0);
        else System.out.print(minLen);
    }
}
