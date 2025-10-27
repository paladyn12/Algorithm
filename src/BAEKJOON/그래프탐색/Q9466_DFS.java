import java.io.*;
import java.util.*;

public class Q9466_DFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;
        int[] arr;
        boolean[] flag;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

            flag = new boolean[N + 1];
            Arrays.fill(flag, true);

            HashMap<Integer, Integer> map;
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (!flag[i]) continue;
                flag[i] = false;

                int cnt = 1;
                map = new HashMap<>();
                map.put(i, cnt);
                
                int current = i;
                flag[current] = false;

                while (true) {
                    current = arr[current];

                    if (flag[current]) {
                        flag[current] = false;
                        map.put(current, ++cnt);
                    } else {
                        break;
                    }
                }

                if (map.containsKey(current)) {
                    sum += cnt - map.get(current) + 1;
                }
            }

            sb.append(N - sum).append("\n");
        }
        System.out.print(sb);
    }
}
