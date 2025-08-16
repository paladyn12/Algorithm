import java.util.*;
import java.io.*;

class Q14425_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) cnt++;
        }

        System.out.print(cnt);
    }
}
