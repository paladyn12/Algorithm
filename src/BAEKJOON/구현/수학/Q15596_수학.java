package BAEKJOON.구현.수학;

/**
 * 문제 번호: 15596
 * 문제 이름: 정수 N개의 합
 * 풀이: 주어진 조건에 대한 함수 구현
 */
class Q15596_수학 {
    public long sum(int[] a) {
        long sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}