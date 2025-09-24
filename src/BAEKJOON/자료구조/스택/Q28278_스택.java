import java.util.*;
import java.io.*;

class Q28278_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            switch(oper) {
                case 1:
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (!dq.isEmpty()) sb.append(dq.pollLast()).append("\n");
                    else sb.append("-1\n");
                    break;
                case 3:
                    sb.append(dq.size()).append("\n");
                    break;
                case 4:
                    if (!dq.isEmpty()) sb.append("0\n");
                    else sb.append("1\n");
                    break;
                case 5:
                    if (!dq.isEmpty()) sb.append(dq.peekLast()).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
