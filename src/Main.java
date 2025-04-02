import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 문제 번호:
 * 문제 이름:
 * 풀이:
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int[] heights = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            heights[i] = num;
        }

        int ex1 = 0;
        int ex2 = 0;
        boolean found = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {

                if (sum - heights[i] - heights[j] == 100) {
                    ex1 = i;
                    ex2 = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != ex1 && i != ex2) {
                result.add(heights[i]);
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        for (Integer i : result) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}