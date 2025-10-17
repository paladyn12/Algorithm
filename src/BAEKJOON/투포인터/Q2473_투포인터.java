import java.io.*;
import java.util.*;

public class Q2473_투포인터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) liquid[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(liquid);

        long resSum = Long.MAX_VALUE;
        int[] resArray = new int[3];
        for (int i = 0; i < N; i++) {
            long pickedLiquid = (long) liquid[i];

            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (start == i) start++;
                if (end == i) end--;

                if (start >= end) break;

                long sum = pickedLiquid + liquid[start] + liquid[end];
                if (Math.abs(sum) < resSum) {
                    resSum = Math.abs(sum);
                    resArray[0] = (int) pickedLiquid;
                    resArray[1] = liquid[start];
                    resArray[2] = liquid[end];
                    if (resSum == 0) break;
                }
                if (sum < 0) start++;
                else if (sum > 0) end--;
            }
            if (resSum == 0) break;
        }
        Arrays.sort(resArray);
        System.out.print(resArray[0] + " " + resArray[1] + " " + resArray[2]);
    }
} 
