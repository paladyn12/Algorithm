import java.util.*;
import java.io.*;

class Q13549_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if (K < N) System.out.print(N - K);
        else {
            int[] distance = new int[100001];
            Arrays.fill(distance, -1);

            ArrayDeque<Integer> queue = new ArrayDeque<>();
            distance[K] = 0;
            queue.addLast(K);
            while (K % 2 == 0) {
                distance[K / 2] = 0;
                queue.addLast(K / 2);
                K /= 2;
            }

            while (distance[N] == -1) {
                int cur = queue.pollFirst();
                int temp = cur;
                while (temp % 2 == 0 && distance[temp / 2] == -1) {
                    if (distance[temp / 2] == -1) {
                        distance[temp / 2] = distance[temp];
                        queue.addLast(temp / 2);
                    }
                    temp /= 2;
                }
            
                if (cur > 0) {
                    int next = cur - 1;
                    if (distance[next] == -1) {
                        distance[next] = distance[cur] + 1;
                        if (next == N) break;
                		queue.addLast(next);
                    }
                }
            
                if (cur < 100000) {
                    int next = cur + 1;
                    if (distance[next] == -1) {
                        distance[next] = distance[cur] + 1;
                        if (next == N) break;
                		queue.addLast(next);
                    }
                }
            }
            System.out.print(distance[N]);
        }
    }
}
