import java.util.*;
import java.io.*;

class Q1952 {

    static int day;
    static int month;
    static int threeMonth;
    static int year;
    static int ans;

    static int[] plans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threeMonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            ans = year;

            plans = new int[13];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plans[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, 0);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int currentMonth, int sum) {
        if (currentMonth >= 13) {
            ans = Math.min(ans, sum);
            return;
        }

        dfs(currentMonth + 3, sum + threeMonth);
        if (plans[currentMonth] * day < month) dfs(currentMonth + 1, sum + plans[currentMonth] * day);
        else dfs(currentMonth + 1, sum + month);
    }
}
