import java.util.*;
import java.io.*;

class Q16637_브루트포스 {

    static int ans = Integer.MIN_VALUE;
    static ArrayList<Character> operators;
    static ArrayList<Integer> numbers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        operators = new ArrayList<>();
        numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                numbers.add(S.charAt(i) - '0');
            } else {
                operators.add(S.charAt(i));
            }
        }

        dfs(0, numbers.get(0));

        System.out.print(ans);        
    }

    static void dfs(int operatorIndex, int currentSum) {
        if (operatorIndex == operators.size()) {
            ans = Math.max(ans, currentSum);
            return;
        }

        // 1. 괄호 없는 경우
        dfs(operatorIndex + 1, calc(currentSum, numbers.get(operatorIndex + 1), operatorIndex));

        // 2. 괄호 있는 경우
        if (operatorIndex + 1 < operators.size()) {
            int nextSum = calc(numbers.get(operatorIndex + 1), numbers.get(operatorIndex + 2), operatorIndex + 1);
            dfs(operatorIndex + 2, calc(currentSum, nextSum, operatorIndex));
        }
    }

    static int calc(int n1, int n2, int operatorIndex) {
        char operator = operators.get(operatorIndex);
        switch (operator) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
        }
        return -1;
    }
}
