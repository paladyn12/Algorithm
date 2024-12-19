package BAEKJOON.구현.수학;

import java.io.*;

/**
 * 문제 번호: 1373
 * 문제 이름: 2진수 8진수
 * 풀이: 3자리씩 끊어 sb에 더함
 */
class Q1373_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int check = str.length()%3;
        if (check == 1) {
            sb.append(str.charAt(0));
        }
        if (check == 2) {
            sb.append((str.charAt(0)-'0')*2 + str.charAt(1)-'0');
        }
        for (int i = check; i < str.length(); i+=3) {
            sb.append(((str.charAt(i))-'0')*4+((str.charAt(i+1))-'0')*2+(str.charAt(i+2))-'0');
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}