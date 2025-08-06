import java.util.*;
import java.io.*;

class Q9375_맵 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                String key = input[1];
                map.put(key, map.getOrDefault(key, 1) + 1);
            }

            int result = 1;
            for (String key : map.keySet()) {
                result *= map.get(key);
            }

            sb.append(result - 1).append("\n");
        }
        System.out.print(sb);
    }
}
