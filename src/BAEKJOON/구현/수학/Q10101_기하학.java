package BAEKJOON.구현.수학;

import java.io.*;
/**
 * 문제 번호: 10101
 * 문제 이름: 삼각형 외우기
 * 풀이: 조건에 따라 값 출력
 */
class Q10101_기하학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int angle1 = Integer.parseInt(br.readLine());
        int angle2 = Integer.parseInt(br.readLine());
        int angle3 = Integer.parseInt(br.readLine());

        if (angle1+angle2+angle3 != 180) {
            bw.write("Error");
        } else {
            if (angle1 == angle2 && angle2 == angle3) bw.write("Equilateral");
            else if (angle1 == angle2 || angle2 == angle3 || angle3 == angle1) bw.write("Isosceles");
            else bw.write("Scalene");
        }
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}