package PROGRAMMERS.PCCP기출문제;

public class 지폐_접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        set(wallet);
        set(bill);

        while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
            bill[0] /= 2;
            answer++;
            set(bill);
        }

        return answer;
    }
    public void set(int[] array) {
        int min = Math.min(array[0], array[1]);
        int max = Math.max(array[0], array[1]);
        array[0] = max;
        array[1] = min;
    }
}