package BAEKJOON.구현.일반;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10824
 * 문제 이름: 네 수
 * 풀이: 네 수를 입력받아 문자열로 더해 parseLong
 */
class Q10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken()+st.nextToken();
        String second = st.nextToken()+st.nextToken();

        System.out.println(Long.parseLong(first) + Long.parseLong(second));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}