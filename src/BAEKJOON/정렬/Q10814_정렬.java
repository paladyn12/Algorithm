package BAEKJOON.정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 번호: 10814
 * 문제 이름: 나이순 정렬
 * 문제 링크: https://www.acmicpc.net/problem/10814
 * 풀이: Comparable을 구현한 Person 배열에 Arrays.sort()
 */
class Q10814_정렬 {
    public static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (age != o.age) {
                return Integer.compare(age, o.age);
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(people, Comparable::compareTo);

        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            sb.append(person.age).append(" ").append(person.name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        br.close();
        bw.close();
    }
}