package BAEKJOON.자료구조.스택;

import java.io.*;
/**
 * 문제 번호: 10799
 * 문제 이름: 쇠막대기
 * 풀이: stack을 겹친 쇠막대기 개수로 표현
 * ()는 레이저이므로 현재 겹친 쇠막대기 수 만큼 sum에 추가, ()의 )를 따로 보지 않기 위해 index++
 * (는 막대 추가이므로 겹친 막대 수++, sum++
 * )는 막대 제거이므로 겹친 막대 수--
 */
class Q10799_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String poll = br.readLine();
        int stack = 0;
        int sum = 0;
        for (int i = 0; i < poll.length(); i++) {
            if (i < poll.length()-1 && poll.charAt(i) == '(' && poll.charAt(i+1) == ')') {
                sum += stack;
                i++;
            } else if (poll.charAt(i) == '(') {
                sum++;
                stack++;
            } else if (poll.charAt(i) == ')') {
                stack--;
            }
        }
        System.out.println(sum);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}