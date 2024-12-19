package BAEKJOON.구현.일반;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 번호: 25206
 * 문제 이름: 너의 평점은
 * 풀이: 각 줄 별로 학점과 등급을 따로 카운트하여 최종 결과 계산
 */
class Q25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        double point = 0.0;
        double score = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String className = st.nextToken();
            double classPoint = Double.parseDouble(st.nextToken());
            String classScore = st.nextToken();

            if (!classScore.equals("P")) {
                point += classPoint;
                switch (classScore) {
                    case "A+":
                        score += 4.5*classPoint;
                        break;
                    case "A0":
                        score += 4.0*classPoint;
                        break;
                    case "B+":
                        score += 3.5*classPoint;
                        break;
                    case "B0":
                        score += 3.0*classPoint;
                        break;
                    case "C+":
                        score += 2.5*classPoint;
                        break;
                    case "C0":
                        score += 2.0*classPoint;
                        break;
                    case "D+":
                        score += 1.5*classPoint;
                        break;
                    case "D0":
                        score += classPoint;
                        break;
                    case "F":
                        break;
                }
            }
        }

        double result = score/point;

        System.out.printf("%f", result);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
    }
}