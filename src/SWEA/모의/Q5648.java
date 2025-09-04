import java.io.*;
import java.util.*;

public class Q5648 {

    static class Atom {
        int x;
        int y;
        int dir;
        int energy;

        public Atom(int x, int y, int dir, int energy) {
            this.x = x * 2;
            this.y = y * 2;
            this.dir = dir;
            this.energy = energy;
        }

        void move() {
            x += dx[dir];
            y += dy[dir];
        }
    }

    static int[] dx = {0, 0, -1 ,1};
    static int[] dy = {1, -1, 0, 0};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int ans = 0;

            int N = Integer.parseInt(br.readLine());

            ArrayDeque<Atom> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                dq.add(new Atom(x, y, dir, energy));
            }

            while (true) {
                HashMap<Integer, Atom> resultMap = new HashMap<>();
                HashSet<Integer> removePosition = new HashSet<>();
                while (!dq.isEmpty()) {
                    Atom atom = dq.pollFirst();
                    atom.move();
                    if (atom.x < -2000 || atom.x > 2000 || atom.y < -2000 || atom.y > 2000) continue;
                    
                    int position = atom.x * 5000 + atom.y;
                    if (resultMap.containsKey(position)) {
                        removePosition.add(position);
                        ans += atom.energy;
                    } else {
                        resultMap.put(position, atom);
                    }
                }
                for (int position : removePosition) {
                    ans += resultMap.get(position).energy;
                }

                for (int position : resultMap.keySet()) {
                    if (removePosition.contains(position)) continue;
                    dq.addLast(resultMap.get(position));
                }

                if (dq.isEmpty()) break;
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
