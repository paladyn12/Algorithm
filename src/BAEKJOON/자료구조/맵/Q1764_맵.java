import java.util.*;
import java.io.*;

class Q1764_맵 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 2) result.add(key);
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
    }
}
