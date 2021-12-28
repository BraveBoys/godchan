package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class location {
    int row;
    int col;
 
    public location(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
}
 
public class Main {
 
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dx = { 0, 0, -1, 1 };
 
    // 범위 검사
    static boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= M) {
            return false;
        }
        return true;
    }
 
    static void solution(int row, int col) {
        Queue<location> q = new LinkedList<location>();
        q.offer(new location(row, col));
        visited[row][col] = true;
        while (!q.isEmpty()) {
            location loc = q.poll();
            //visited[loc.row][loc.col] = true; 초기 방문체크 위치
 
            for (int i = 0; i < 4; i++) {
                int nexty = loc.row + dy[i];
                int nextx = loc.col + dx[i];
 
                if (!isValid(nexty, nextx) || visited[nexty][nextx] || map[nexty][nextx] == 0) // 범위
                    continue;
 
                map[nexty][nextx] = map[loc.row][loc.col] + 1;
                visited[nexty][nextx] = true;
                q.offer(new location(nexty, nextx));
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
 
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
 
        // ============================== 입력 ==============================
        solution(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }
 
}
