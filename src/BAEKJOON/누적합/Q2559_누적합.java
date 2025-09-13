import java.util.*;
import java.io.*;

class Q2559_누적합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int currentSum = 0;
        for (int i = 0; i < K; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        for (int i = K; i < N; i++) {
            currentSum = currentSum + arr[i] - arr[i - K];
            
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.print(maxSum);
    }
}
