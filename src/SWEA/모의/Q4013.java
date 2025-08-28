import java.util.*;
import java.io.*;

class Q4013 {

    static class Magnet {
        boolean[] blade;

        public Magnet() {
            blade = new boolean[8];
        }

        public void rotate(int dir) {
            if (dir == 1) {
                boolean temp = blade[7];
                for (int i = 7; i > 0; i--) {
                    blade[i] = blade[i - 1];
                }
                blade[0] = temp;
            } else {
                boolean temp = blade[0];
                for (int i = 0; i < 7; i++) {
                    blade[i] = blade[i + 1];
                }
                blade[7] = temp;
            }
        }
    }

    static Magnet[] magnets = new Magnet[4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            magnets[i] = new Magnet();
        }

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            int K = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) magnets[i].blade[j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());
                if (dir == 1) {
                    rotateLeft(idx, -1);
                    rotateRight(idx, -1);
                } else {
                    rotateLeft(idx, 1);
                    rotateRight(idx, 1);
                }
                magnets[idx].rotate(dir);
            }

            int ans = 0;
            if (magnets[0].blade[0]) ans+=1;
            if (magnets[1].blade[0]) ans+=2;
            if (magnets[2].blade[0]) ans+=4;
            if (magnets[3].blade[0]) ans+=8;
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void rotateLeft(int idx, int dir) {
        
        if (idx == 0) return;
        if ((!magnets[idx - 1].blade[2] && magnets[idx].blade[6]) || (magnets[idx - 1].blade[2] && !magnets[idx].blade[6])) {
            if (dir == 1) rotateLeft(idx - 1, -1);
            else rotateLeft(idx - 1, 1);
            magnets[idx - 1].rotate(dir);
        }
    }

    static void rotateRight(int idx, int dir) {
        if (idx == 3) return;
        if ((!magnets[idx + 1].blade[6] && magnets[idx].blade[2]) || (magnets[idx + 1].blade[6] && !magnets[idx].blade[2])) {
            if (dir == 1) rotateRight(idx + 1, -1);
            else rotateRight(idx + 1, 1);
            magnets[idx + 1].rotate(dir);
        }
    }

    
}
