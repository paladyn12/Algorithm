import java.util.*;
import java.io.*;

class Point {
    
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Q2166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double result = 0;
        for (int i = 0; i < N; i++) {
            result += (double) points[i].x * points[(i + 1) % N].y;
            result -= (double) points[i].y * points[(i + 1) % N].x;
        }
        
        System.out.printf("%.1f", Math.abs(result / 2));
    }
}
