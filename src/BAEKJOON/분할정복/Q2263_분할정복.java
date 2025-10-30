import java.io.*;
import java.util.*;

public class Q2263_분할정복 {

    static int N;
    static int[] inIdx;
    static int[] in;
    static int[] post;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        in = new int[N + 1];
        inIdx = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(st.nextToken());
            in[i] = n;
            inIdx[n] = i;
        }

        st = new StringTokenizer(br.readLine());
        post = new int[N + 1];
        for (int i = 1; i <= N; i++) post[i] = Integer.parseInt(st.nextToken());

        solve(1, N, 1, N);
        
        System.out.print(sb);
    }

    static void solve(int is, int ie, int ps, int pe) {
		if(ie < is || pe < ps) return;
		int root = post[pe];
		int rIdx = inIdx[root];
		sb.append(root+" ");
		
		int len = rIdx - is; // left 트리 길이 
		// left 트리 
		solve(is, rIdx-1, ps, ps+len-1);
		// right 트리 
		solve(rIdx+1, ie, ps+len, pe-1);
	}
}
