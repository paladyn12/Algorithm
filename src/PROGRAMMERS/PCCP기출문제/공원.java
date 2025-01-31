package PROGRAMMERS.PCCP기출문제;

public class 공원 {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;

        for (int mat : mats) {
            if(logic(mat, park)) answer = Math.max(answer, mat);
        }

        if (answer == 0) answer = -1;
        return answer;
    }
    public boolean logic(int mat, String[][] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")) {
                    if (i + mat <= park.length && j + mat <= park[0].length)
                        if (check(mat, park, i, j)) return true;
                }
            }
        }
        return false;
    }
    public boolean check(int mat, String[][] park, int n, int m) {
        for (int i = 0; i < mat; i++) {
            for (int j = 0; j < mat; j++) {
                if (!park[n+i][m+j].equals("-1")) return false;
            }
        }
        return true;
    }
}