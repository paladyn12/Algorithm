import java.io.*;
import java.util.*;

public class Q2098_TSP {

    static int N; // 도시의 수
    static int[][] W; // W[i][j] = i에서 j로 가는 비용
    static long[][] dp;
    
    static final int START_CITY = 0; // 시작 도시
    static int ALL_VISITED_MASK; // 모든 도시를 방문했음을 나타내는 마스크
    
    // N(최대 16) * 최대 비용(1,000,000) = 16,000,000
    // INF는 이보다 충분히 큰 값으로 설정
    static final long INF = 100_000_000L; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        
        ALL_VISITED_MASK = (1 << N) - 1;

        // dp[i][j]: 
        //   현재 i번 도시에 있고, 
        //   방문한 도시들의 집합이 j(비트마스크)일 때,
        //   앞으로 방문해야 할 나머지 도시들을 모두 방문하고 
        //   START_CITY로 돌아오는 데 드는 최소 비용
        dp = new long[N][1 << N];

        // 비용 행렬(W) 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 테이블 초기화 (아직 계산되지 않은 상태를 -1로 표시)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 0번 도시에서 방문 시작
        // (현재 0번 도시에 있고, 방문한 도시는 0번(1 << 0) 뿐인 상태)
        long result = solve(START_CITY, 1 << START_CITY);
        
        System.out.println(result);
    }

    /**
     * TSP 문제를 푸는 재귀 함수 (DP + 메모이제이션)
     * @param curr 현재 위치한 도시
     * @param mask 현재까지 방문한 도시들의 비트마스크
     * @return 앞으로 남은 도시들을 모두 방문하고 시작 도시로 돌아가는 데 드는 최소 비용
     */
    static long solve(int curr, int mask) {
        
        // 1. Base Case: 모든 도시를 방문한 경우
        if (mask == ALL_VISITED_MASK) {
            if (W[curr][START_CITY] > 0) { // 시작 도시(0번)로 돌아갈 수 있는가?
                return W[curr][START_CITY]; // 돌아가는 비용 반환
            } else {
                // 돌아갈 수 없으면, 이 경로는 무효함
                return INF; 
            }
        }

        // 2. Memoization: 이미 이 상태를 계산한 적이 있는가?
        if (dp[curr][mask] != -1) {
            return dp[curr][mask]; // 이전에 계산한 값 반환
        }

        // 3. Recursive Step: 
        // 현재 상태(curr, mask)의 최소 비용을 INF로 초기화
        // (아직 방문하지 않았으므로)
        dp[curr][mask] = INF; 

        // 다음으로 방문할 도시(next)를 0번부터 N-1번까지 탐색
        for (int next = 0; next < N; next++) {
            
            // 3-1. (next 도시를 이미 방문한 경우) -> 스킵
            if ((mask & (1 << next)) != 0) continue; 
            
            // 3-2. (curr에서 next로 가는 길이 없는 경우) -> 스킵
            if (W[curr][next] == 0) continue;

            // 'next' 도시를 방문하고, mask에 'next'를 추가하여 재귀 호출
            long cost = W[curr][next] + solve(next, mask | (1 << next));
            
            // 현재 상태(curr, mask)에서 계산된 최소 비용을 갱신
            // (기존 최소값과 'next'를 거쳐가는 경로의 비용 중 더 작은 값)
            dp[curr][mask] = Math.min(dp[curr][mask], cost);
        }

        // 4. 현재 상태(curr, mask)에서 계산된 최소 비용 반환
        return dp[curr][mask];
    }
}
