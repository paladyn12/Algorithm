import java.io.*;
import java.util.ArrayList;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이 :
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int last = 1;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (last <= input) {
                while (last <= input) {
                    stack.add(last);
                    last++;
                    sb.append("+\n");
                }
                stack.remove(stack.size()-1);
                sb.append("-\n");
            } else {
                if (stack.get(stack.size()-1) != input) {
                    System.out.println("NO");
                    System.exit(0);
                } else {
                    stack.remove(stack.size()-1);
                    sb.append("-\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}