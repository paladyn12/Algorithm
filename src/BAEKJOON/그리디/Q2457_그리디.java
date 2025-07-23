import java.util.*;
import java.io.*;

class Flower {
    Day start;
    Day end;
    
    public Flower(int startMonth, int startDay, int endMonth, int endDay) {
        this.start = new Day(startMonth, startDay);
        this.end = new Day(endMonth, endDay);    
    }
}

class Day {
    int month;
    int day;
    public Day(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public int calc() {
        return month * 100 + day;
    }
}

class Q2457_그리디 {

    static int N;
    static Day now = new Day(3, 1);
    static Day goal = new Day(11, 30);
    static int cnt = 0;
    static Flower[] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm, sd, em, ed);
        }

        while (true) {
            now = logic();
            cnt++;
            if (goal.calc() < now.calc()) break;
        }

        System.out.print(cnt);
    }

    static Day logic() {
        int result = -1;
        for (int i = 0; i < N; i++) {
            Flower f = flowers[i];
            if (!compareDay(f)) continue;
            result = Math.max(result, f.end.calc());
        }

        if (result == -1) {
            System.out.print(0);
            System.exit(0);
        }
        return new Day(result / 100, result % 100);
    }

    static boolean compareDay(Flower f) {
        int start = f.start.calc();
        int end = f.end.calc();
        if (start <= now.calc() && end > now.calc()) return true;
        else return false;
    }
    
}
