import java.io.*;
import java.util.*;

public class Q6782 {

    static HashMap<Long, Integer> cntMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	
            long N = Long.parseLong(br.readLine());
            int ans = cntMap.containsKey(N) ? cntMap.get(N) : find(N);
            
        	sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
	}

    static int find(long l) {
        if (l == 2) return 0;
        long sqrt = (long) Math.sqrt(l);
        if (sqrt * sqrt == l) {
            cntMap.put(l, find(sqrt) + 1);
        } else {
            long next = (sqrt + 1) * (sqrt + 1);
            cntMap.put(l, find(next) + (int) (next - l));
        }
        return cntMap.get(l);
    }
}
