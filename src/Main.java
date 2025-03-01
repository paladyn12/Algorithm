import java.io.*;
import java.util.*;

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

        ArrayDeque<Character> stack = new ArrayDeque<>();
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && priority(stack.peekLast()) >= priority(c)) {
                        sb.append(stack.pollLast());
                    }
                    stack.addLast(c);
                    break;
                case '(' :
                    stack.addLast('(');
                    break;
                case ')' :
                    while (!stack.isEmpty() && stack.peekLast() != '(') {
                        sb.append(stack.pollLast());
                    }
                    stack.pollLast();
                    break;
                default:
                    sb.append(c);
            }

        }

        while (!stack.isEmpty())
            sb.append(stack.pollLast());

        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
    public static int priority(char operator){
        if(operator=='(' || operator==')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}