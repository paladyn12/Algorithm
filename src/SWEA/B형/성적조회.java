import java.util.*;

class 성적조회 {

    static class Result {
        int id;
        int grade;
        boolean isMale;
        int score;

        public Result(int id, int grade, char[] mGender, int score) {
            this.id = id;
            this.grade = grade;
            this.isMale = mGender[0] == 'm';
            this.score = score;
        }
    }

    static Comparator<Result> descComp = (a, b) -> {
        if (a.score != b.score) return Integer.compare(b.score, a.score);
        return Integer.compare(b.id, a.id);
    };

    static Comparator<Result> ascComp = (a, b) -> {
        if (a.score != b.score) return Integer.compare(a.score, b.score);
        return Integer.compare(a.id, b.id);
    };

    // id -> Result 매핑
    HashMap<Integer, Result> idToResult;

    // 학년(1~3), 성별(0=male,1=female)
    TreeSet<Result>[][] descSets;
    TreeSet<Result>[][] ascSets;

    public void init() {
        idToResult = new HashMap<>();
        descSets = new TreeSet[4][2];
        ascSets = new TreeSet[4][2];
        for (int i = 1; i <= 3; i++) {
            descSets[i][0] = new TreeSet<>(descComp);
            descSets[i][1] = new TreeSet<>(descComp);
            ascSets[i][0] = new TreeSet<>(ascComp);
            ascSets[i][1] = new TreeSet<>(ascComp);
        }
    }

    public int add(int mId, int mGrade, char mGender[], int mScore) {
        Result r = new Result(mId, mGrade, mGender, mScore);
        idToResult.put(mId, r);

        int g = r.isMale ? 0 : 1;
        descSets[mGrade][g].add(r);
        ascSets[mGrade][g].add(r);

        return descSets[mGrade][g].first().id;
    }

    public int remove(int mId) {
        if (!idToResult.containsKey(mId)) return 0;

        Result r = idToResult.get(mId);
        idToResult.remove(mId);

        int g = r.isMale ? 0 : 1;
        descSets[r.grade][g].remove(r);
        ascSets[r.grade][g].remove(r);

        if (ascSets[r.grade][g].isEmpty()) return 0;
        return ascSets[r.grade][g].first().id;
    }

    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
        Result answer = null;

        for (int gi = 0; gi < mGradeCnt; gi++) {
            int grade = mGrade[gi];
            for (int gj = 0; gj < mGenderCnt; gj++) {
                boolean isMale = mGender[gj][0] == 'm';
                int g = isMale ? 0 : 1;

                TreeSet<Result> set = ascSets[grade][g];
                if (set.isEmpty()) continue;

                // mScore 이상인 최저점 찾기
                Result dummy = new Result(Integer.MIN_VALUE, grade, new char[]{isMale ? 'm' : 'f'}, mScore);
                Result candidate = set.ceiling(dummy);
                if (candidate == null) continue;

                // 가장 낮은 점수 & ID 작은 학생 갱신
                if (answer == null ||
                        candidate.score < answer.score ||
                        (candidate.score == answer.score && candidate.id < answer.id)) {
                    answer = candidate;
                }
            }
        }

        return answer == null ? 0 : answer.id;
    }
}
