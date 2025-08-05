import java.util.*;
import java.io.*;

class Q9019_BFS {

    static StringBuilder sb = new StringBuilder();
    static String[] visit;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());
            
            visit = new String[10000];
            visit[start] = "";
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.addLast(start);
            while (!dq.isEmpty()) {

                Integer curInt = dq.pollFirst();
                String curStr = visit[curInt];
                
                int D = (curInt * 2) % 10000;
                int S = (curInt + 9999) % 10000;
                int L = ((curInt * 10) % 10000) + (curInt / 1000);
                int R = (curInt % 10) * 1000 + (curInt / 10);

                if (visit[D] == null) {
                    visit[D] = curStr + "D";
                    dq.addLast(D);
                }
                if (visit[S] == null) {
                    visit[S] = curStr + "S";
                    dq.addLast(S);
                }
                if (visit[L] == null) {
                    visit[L] = curStr + "L";
                    dq.addLast(L);
                }
                if (visit[R] == null) {
                    visit[R] = curStr + "R";
                    dq.addLast(R);
                }

                if (visit[goal] != null) break;
            }

            sb.append(visit[goal]).append("\n");
        }
        System.out.print(sb);
    }
}
