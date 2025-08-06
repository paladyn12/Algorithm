import java.util.*;
import java.io.*;

class Q7662_맵 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                char op = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);
                if (op == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;
                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }

            if (map.isEmpty())
                sb.append("EMPTY\n");
            else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
