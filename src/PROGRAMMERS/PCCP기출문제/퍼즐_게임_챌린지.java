package PROGRAMMERS.PCCP기출문제;

public class 퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100001;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long result = calculateTime(diffs, times, mid);
            if (result <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;
    }

    private long calculateTime(int[] diffs, int[] times, int n) {
        long total = 0;

        if (n >= diffs[0]) total += times[0];
        else total += (diffs[0] - n + 1) * times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (n >= diffs[i]) {
                total += times[i];
            } else {
                total += (diffs[i] - n) * (times[i] + times[i - 1]) + times[i];
            }
        }

        return total;
    }
}
