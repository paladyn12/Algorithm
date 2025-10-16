import java.util.*;
import java.io.*;

class Q27172_브루트포스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputOrder = new int[N];
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            set.add(n);
            max = Math.max(max, n);
            inputOrder[i] = n;
        }

        int[] score = new int[max + 1];
        for (int i : set) {
            for (int j = i; j <= max; j += i) {
                if (set.contains(j)) {
                    score[i]++;
                    score[j]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(score[inputOrder[i]]).append(" ");
        System.out.print(sb);
    }
}
