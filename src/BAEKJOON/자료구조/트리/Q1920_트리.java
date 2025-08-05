import java.util.*;
import java.io.*;

class Q1920_트리 {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> tree = new TreeSet<>();
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (tree.contains(Integer.parseInt(st.nextToken()))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        
        System.out.print(sb);
    }
}
