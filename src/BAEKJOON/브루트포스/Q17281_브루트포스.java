import java.util.*;
import java.io.*;

class Q17281_브루트포스 {

    // 이닝 수
    static int N;
    // 이닝 별 선수들의 결과
    static int[][] batterInfo;
    // 현재 아웃 수
    static int out;
    // 진행한 타자 수
    static int currentBatter;
    // 출루한 타자 정보
    static boolean[] baseInfo;
    // 타자 순서
    static int[] batters = new int[10];
    // 타자 순서 순열
    static boolean[] visit = new boolean[10];
    
    // 정답
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        batterInfo = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                batterInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1);

        System.out.print(ans);
    }

    static void dfs(int depth) {
        if (depth == 10) {
            //System.out.println(Arrays.toString(batters));
            ans = Math.max(ans, play());
            return;
        }

        if (depth == 4) {
            batters[depth] = 1;
            dfs(depth + 1);
        } else {
            for (int i = 2; i <= 9; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    batters[depth] = i;
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    static int play() {
        int score = 0;
        currentBatter = 1;
        for (int i = 1; i <= N; i++) {
            // i 번째 이닝 진행
            score += ining(i);
        }
        return score;
    }

    static int ining(int n) {
        int iningScore = 0;
        out = 0;
        baseInfo = new boolean[3];
        while (out < 3) {
            int info = batterInfo[n][batters[currentBatter]];
            currentBatter = (currentBatter % 9) + 1;

            switch (info) {
                case 0:
                    out++;
                    break;
                case 1:
                    if (baseInfo[2]) {
                        iningScore++;
                        baseInfo[2] = false;
                    }
                    if (baseInfo[1]) {
                        baseInfo[2] = true;
                        baseInfo[1] = false;
                    }
                    if (baseInfo[0]) {
                        baseInfo[1] = true;
                        baseInfo[0] = false;
                    }
                    baseInfo[0] = true;
                    break;
                case 2:
                    if (baseInfo[2]) {
                        iningScore++;
                        baseInfo[2] = false;
                    }
                    if (baseInfo[1]) {
                        iningScore++;
                        baseInfo[1] = false;
                    }
                    if (baseInfo[0]) {
                        baseInfo[2] = true;
                        baseInfo[0] = false;
                    }
                    baseInfo[1] = true;
                    break;
                case 3:
                    if (baseInfo[2]) {
                        iningScore++;
                        baseInfo[2] = false;
                    }
                    if (baseInfo[1]) {
                        iningScore++;
                        baseInfo[1] = false;
                    }
                    if (baseInfo[0]) {
                        iningScore++;
                        baseInfo[0] = false;
                    }
                    baseInfo[2] = true;
                    break;
                case 4:
                    int cnt = 0;
                    for (int i = 0; i <= 2; i++) {
                        if (baseInfo[i]) {
                            iningScore++;
                            baseInfo[i] = false;
                        }
                    }
                    iningScore++;
            }
        }
        return iningScore;
    }
}
