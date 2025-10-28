import java.io.*;
import java.util.*;

public class Q10775_유니온파인드 {

    static int[] parents;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        parents = new int[G + 1];
        for (int i = 1; i <= G; i++) parents[i] = i;
        
        int P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int fg1 = find(g);
            if (fg1 == 0) {
                break;
            }
            else {
                int fg2 = find(fg1 - 1);
                union(fg1, fg2);
                ans++;
            }
        }
        System.out.print(ans);
    }

    static int find(int a) {
        if (a != parents[a]) {
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }

    static void union(int a, int b) {
        parents[a] = b;
    }
}
