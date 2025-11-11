import java.io.*;
import java.util.*;

public class Q2568_이분탐색 {

    static class Line implements Comparable<Line> {
        int from;
        int to;
        
        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int compareTo(Line o) {
            return Integer.compare(from, o.from);
        }
    }

    static Line[] lines;
    static int[] lis;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        lis = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lines[i] = new Line(from, to);
        }

        Arrays.sort(lines);

        lis[0] = lines[0].to;
        dp[0] = 0; // lines[0]은 LIS의 0번째 인덱스에 위치
        int lisLen = 1;
        for (int i = 1; i < N; i++) {
            int key = lines[i].to;
            
            if (lis[lisLen - 1] < key) {
                lis[lisLen] = key;
                dp[i] = lisLen;
                lisLen++;
            } else {
                int left = 0;
                int right = lisLen;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                
                lis[left] = key;
                dp[i] = left;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N - lisLen).append("\n");

        boolean[] check = new boolean[N]; // LIS에 포함되면 true
        
        // LIS의 가장 마지막 인덱스부터 (길이 - 1)
        int targetIndex = lisLen - 1; 

        // 전깃줄 배열을 뒤에서부터 탐색
        for (int i = N - 1; i >= 0; i--) {
            // 현재 전깃줄(lines[i])의 dp 값이 우리가 찾는 targetIndex와 같다면
            // 이 전깃줄은 LIS의 구성원이 맞음
            if (dp[i] == targetIndex) {
                check[i] = true;
                targetIndex--; // 다음 (더 앞쪽) LIS 구성원을 찾음
            }
        }

        // 4. LIS에 포함되지 않은(check[i] == false) 전깃줄의 from 번호 출력
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                sb.append(lines[i].from).append("\n");
            }
        }

        System.out.print(sb);
    }
}
