import java.io.*;
import java.util.*;

public class Q9328_BFS {

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int h;
    static int w;
    static char[][] map;
    static HashSet<Integer> keys;
    static ArrayList<Node> locked;
    static boolean[][] visited;
    static int ans;

    static String input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            ans = 0;
            
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            
            map = new char[h + 2][w + 2];
            for (int i = 0; i <= h + 1; i++) {
                if (i == 0 || i == h + 1) {
                    Arrays.fill(map[i], '.');
                    continue;
                }
                
                input = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
                map[i][0] = '.';
                map[i][w + 1] = '.';
            }

            keys = new HashSet<>();
            input = br.readLine();
            if (!input.equals("0")) {
                for (int i = 0; i < input.length(); i++) {
                    keys.add(input.charAt(i) - 32);
                }
            }

            locked = new ArrayList<>();

            visited = new boolean[h + 2][w + 2];
            bfs(new Node(0, 0));

            while (true) {
                boolean flag = false;
                for (Node door : locked) {
                    if (keys.contains((int) map[door.x][door.y])) {
                        bfs(door);
                        locked.remove(door);
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
            }
            sb.append(ans).append("\n");
        }
        
        System.out.print(sb);
    }

    static void bfs(Node start) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        map[start.x][start.y] = '.';
        dq.addLast(new Node(start.x, start.y));

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= h + 2 || ny < 0 || ny >= w + 2) continue;
                if (map[nx][ny] == '*') continue;
                if (map[nx][ny] == '$') {
                    map[nx][ny] = '.';
                    visited[nx][ny] = true;
                    ans++;
                    dq.addLast(new Node(nx, ny));
                } else if (map[nx][ny] == '.' && !visited[nx][ny]) {
                      visited[nx][ny] = true;
                    dq.addLast(new Node(nx, ny));
                } else if (map[nx][ny] >= 97 && map[nx][ny] <= 122) {
                    keys.add(map[nx][ny] - 32);
                    map[nx][ny] = '.';
                    visited[nx][ny] = true;
                    dq.addLast(new Node(nx, ny));
                } else if (map[nx][ny] >= 65 && map[nx][ny] <= 90) {
                    if (keys.contains((int) map[nx][ny])) {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        dq.addLast(new Node(nx, ny));
                    } else {
                        locked.add(new Node(nx, ny));
                    }
                }
            }
        }
    }
}
