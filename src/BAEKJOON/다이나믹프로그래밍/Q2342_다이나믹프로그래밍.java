import java.io.*;
import java.util.*;

public class Q2342_다이나믹프로그래밍 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> opers = new ArrayList<>();
        while (true) {
            int oper = Integer.parseInt(st.nextToken());
            if (oper != 0) opers.add(oper);
            else break;
        }

        if (opers.isEmpty()) {
            System.out.print(0);
            System.exit(0);
        }

        int[][][] dp = new int[opers.size()][5][5];
        for (int i = 0; i < opers.size(); i++) for (int j = 0; j <= 4; j++) Arrays.fill(dp[i][j], 10000000);

        for (int i = 0; i < opers.size(); i++) {
            int oper = opers.get(i);
            if (i == 0) {
                dp[0][oper][0] = 2;
                dp[0][0][oper] = 2;
            }
            else {
                for (int j = 0; j <= 4; j++) {
                    for (int k = 0; k <= 4; k++) {
                        if (k == oper) continue;
                        dp[i][oper][k] = Math.min(dp[i][oper][k], dp[i-1][j][k] + move(j, oper));
                        dp[i][k][oper] = Math.min(dp[i][k][oper], dp[i-1][k][j] + move(j, oper));
                    }
                }
            }
            
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 4; i++) for (int j = 0; j <= 4; j++) ans = Math.min(ans, dp[opers.size()-1][i][j]);
        
        System.out.print(ans);
    }

    static int move(int from, int to) {
        switch (from) {
            case 0:
                return 2;
            case 1:
                if (to == 1) return 1;
                if (to == 2) return 3;
                if (to == 3) return 4;
                if (to == 4) return 3;
            case 2:
                if (to == 1) return 3;
                if (to == 2) return 1;
                if (to == 3) return 3;
                if (to == 4) return 4;
            case 3:
                if (to == 1) return 4;
                if (to == 2) return 3;
                if (to == 3) return 1;
                if (to == 4) return 3;
            case 4:
                if (to == 1) return 3;
                if (to == 2) return 4;
                if (to == 3) return 3;
                if (to == 4) return 1;
        }
        return 0;
    }
} 
