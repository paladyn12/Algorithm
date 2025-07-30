import java.util.*;
import java.io.*;

class Q21608 {

    static int N;
    static int[][] classroom;
    static HashMap<Integer, Integer[]> friend = new HashMap<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        classroom = new int[N][N];
        
        for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			int s4 = Integer.parseInt(st.nextToken());
			int s5 = Integer.parseInt(st.nextToken());
			//해시맵에 좋아하는 친구 저장
    			friend.put(s1,new Integer[] {s2,s3,s4,s5});
			//현재 학생의 자리를 구함
			putStudent(s1);
		}

        //만족도 조사
		int sum = 0;
		for(int i = 0; i < classroom.length; i++) {
			for(int j = 0; j < classroom.length; j++) {
				
				int count = 0;
				Integer friends[] = friend.get(classroom[i][j]);
				for (int k = 0; k < 4; k++) {
					int nextY = i + dy[k];
					int nextX = j + dx[k];
					if (nextY < 0 || nextX < 0 || nextY >= classroom.length || nextX >= classroom.length) continue;
                    
					int now = classroom[nextY][nextX];
					//상,하,좌,우가 친구면 count 증가
					for(int p = 0; p < 4; p++)
						if(now == friends[p]) count++;
					
				}
                
				//count 개수에 따라 sum 증가
				switch(count) {
    				case 1: sum += 1; break;
    				case 2: sum += 10; break;
    				case 3: sum += 100; break;
    				case 4: sum += 1000; break;
				}
			}
		}

        System.out.print(sum);
    }

    public static void putStudent(int student) {
		
		Integer friends[] = friend.get(student);
		int f1 = friends[0];
		int f2 = friends[1];
		int f3 = friends[2];
		int f4 = friends[3];
		
		ArrayList<Integer[]> list=new ArrayList<>();
		for(int i=0;i<classroom.length;i++) {
			for(int j=0;j<classroom.length;j++) {
				int friendsCount = 0;
				int emptyCount = 0;
				for(int k=0;k<4;k++) {
					int nextY=i+dy[k];
					int nextX=j+dx[k];
					if(nextY<0||nextX<0||nextY>=classroom.length||nextX>=classroom.length)
						continue;
					//해당 좌표가 좋아하는 학생이면 친구 count 증가
					//해당 좌표가 빈 공간이면 빈 공간 count 증가
					int now = classroom[nextY][nextX];
					if(now==f1||now==f2||now==f3||now==f4)
						friendsCount++;
					if(now==0)
						emptyCount++;
					
				}
				list.add(new Integer[] {friendsCount,emptyCount,i,j});
				
			}
		}
		//정렬함. 정렬 기준 -> 선호 학생의 수, 빈 자리의 수, 행, 열
		Collections.sort(list,new Comparator<>() {
			@Override
			public int compare(Integer n1[],Integer n2[]) {
				if(n1[0]<n2[0]) return 1;
				else if(n1[0]==n2[0]) {
					if(n1[1]<n2[1]) return 1;
					else if(n1[1]==n2[1]) {
						if(n1[2]>n2[2]) return 1;
						else if(n1[2]==n2[2]) {
							if(n1[3]>n2[3]) return 1;
						}
						
					}
				}
				return -1;
			}
		});
		
		//0번째 인덱스부터 시작해서 해당 좌표가 0이 아니라면, 그 좌표가 현재 학생의 자리가 됨.
		for(int i=0;i<list.size();i++) {
			int y = list.get(i)[2];
			int x = list.get(i)[3];
			if(classroom[y][x]==0) {
				classroom[y][x] = student;
				return;
			}
		}
	}
}
