import java.util.*;
import java.io.*;

class Q2108_수학 {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] cnt = new int[8001];
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            array[i] = n;
            cnt[n + 4000]++;
        }

        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
        }
        sum /= N;
        sb.append(Math.round(sum)).append("\n");

        Arrays.sort(array);
        sb.append(array[N/2]).append("\n");

        int maxCnt = 0;
        int minIdx = 0;
        int maxIdx = 0;
        for (int i = 0; i <= 8000; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= 8000; i++) {
            if (cnt[i] == maxCnt) {
                pq.offer(i);
            }
        }

        if (pq.size() != 1) pq.poll();
        sb.append(pq.poll() - 4000).append("\n");

        for (int i = 0; i <= 8000; i++) {
            if (cnt[i] != 0) {
                minIdx = i;
                break;
            }
        }
        
        for (int i = 8000; i >= 0; i--) {
            if (cnt[i] != 0) {
                maxIdx = i;
                break;
            }
        }

        sb.append(maxIdx - minIdx).append("\n");
        
        System.out.print(sb);
    }
}
