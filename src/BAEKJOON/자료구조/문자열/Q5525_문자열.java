import java.util.*;
import java.io.*;

class Q5525_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] countArray = new int[M + 1];
        char lastChar = 'O';
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            char currentChar = S.charAt(i - 1);

            // 이전 문자와 같으면 실패
            if (lastChar == currentChar) {
                if (currentChar == 'O')
                    countArray[i] = 0;
                else countArray[i] = 1;
            } else {
                // 이전과 다른 문자면 카운팅++
                countArray[i] = countArray[i - 1] + 1;
                if (countArray[i] == 2 * N + 1) {
                    ans++;
                    countArray[i] -= 2;
                }
            }
            lastChar = currentChar;
        }
        System.out.print(ans);
    }
}
