package Algorithm.정렬;


public class ComparatorImpl {
    public static class C implements Comparable<Integer> {

        int num;

        @Override
        public int compareTo(Integer o) {
            if (num > o) return 1; // sort할 조건
            else if (num == o) return 0;
            return -1;
        }

        @Override
        public String toString() {
            return "";
        }
    }
}
