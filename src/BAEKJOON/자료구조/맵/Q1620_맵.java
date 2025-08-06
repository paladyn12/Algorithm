import java.util.*;
import java.io.*;

class Q1620_맵 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numberMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            char first = q.charAt(0);
            if (first - '0' >= 1 && first - '0' <= 9) {
                sb.append(numberMap.get(Integer.parseInt(q))).append("\n");
            } else {
                sb.append(nameMap.get(q)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
