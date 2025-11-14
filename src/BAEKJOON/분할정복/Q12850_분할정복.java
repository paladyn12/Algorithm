import java.util.*;
import java.io.*;
/*

*/
class Q12850_분할정복 {
    
    // 행렬의 크기 (건물 개수)
    static final int N = 8;
    // 모듈러
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        // 입력 받기 (Scanner 대신 BufferedReader 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long D = Long.parseLong(br.readLine());

        // 2단계: 인접 행렬 초기화
        // 0:정보, 1:전산, 2:미래, 3:신양, 4:진리, 5:한경, 6:학생, 7:형남
        long[][] adj = new long[N][N];
        
        // 간선 연결 (양방향)
        adj[0][1] = adj[1][0] = 1; // 정보-전산
        adj[0][2] = adj[2][0] = 1; // 정보-미래
        
        adj[1][2] = adj[2][1] = 1; // 전산-미래
        adj[1][3] = adj[3][1] = 1; // 전산-신양
        adj[2][3] = adj[3][2] = 1; // 미래-신양
        
        adj[3][4] = adj[4][3] = 1; // 신양-진리
        adj[3][5] = adj[5][3] = 1; // 신양-한경
        adj[2][5] = adj[5][2] = 1; // 미래-한경
        adj[4][5] = adj[5][4] = 1; // 진리-한경
        
        adj[4][6] = adj[6][4] = 1; // 진리-학생
        adj[5][7] = adj[7][5] = 1; // 한경-형남
        adj[6][7] = adj[7][6] = 1; // 학생-형남

        // 4단계: 행렬 거듭제곱 계산
        long[][] result = power(adj, D);

        // 0번(정보관)에서 출발해 D분 후 0번(정보관)에 도착하는 경우의 수
        System.out.println(result[0][0]);
    }
    
    /**
     * 행렬 곱셈 함수 (모듈러 연산 포함)
     * c = a * b
     */
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    long temp = (a[i][k] * b[k][j]) % MOD;
                    c[i][j] = (c[i][j] + temp) % MOD;
                }
            }
        }
        return c;
    }

    /**
     * 행렬 거듭제곱 함수 (분할 정복)
     * A^d
     */
    public static long[][] power(long[][] a, long d) {
        // 결과 행렬을 단위 행렬로 초기화
        long[][] res = new long[N][N];
        for (int i = 0; i < N; ++i) {
            res[i][i] = 1;
        }

        // 분할 정복을 이용한 거듭제곱 (이진수 방식)
        while (d > 0) {
            // d가 홀수이면 (d의 마지막 비트가 1이면)
            if (d % 2 == 1) {
                res = multiply(res, a);
            }
            a = multiply(a, a);
            d /= 2;
        }
        return res;
    }
}
