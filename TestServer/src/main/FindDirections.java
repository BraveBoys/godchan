package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FindDirections {
	public static int rows = 0;    // ���
    public static int cols = 0;    // ����    
    public static int[][] map = null;    // ������
    public static String path = "";        // �̵����
    
    public static void main(String[] args) throws FileNotFoundException {
        // �Է����� �ؽ�Ʈ ����
    	
        System.setIn(new FileInputStream("C:/Users/J5409/Desktop/BFS.txt"));
        Scanner scanner = new Scanner(System.in);
        
        long begin = System.currentTimeMillis();
        
        // �׽�Ʈ �� 
        int testCnt = scanner.nextInt();
        
        for (int i = 1; i <= testCnt; i++) {
            rows = scanner.nextInt();    // ���
            cols = scanner.nextInt();    // ����
            
            // ������
            map = new int[rows][cols];
            
            // ������ ����
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    map[j][k] = scanner.nextInt();
                }
            }
            // ����� map ���
//            for (int j = 0; j < rows; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
            
            int dap = 0;
            path = "";
            dap = bfs();
            System.out.println("#" + i + " " + dap + " " + path);
            
            map = null;
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("%.3f (secs)", (end-begin)/1000.0);
        
        scanner.close();
    }
 
    private static int bfs() {
        int ret = 0;
        
        int curRow = 0;        // ���� row
        int curCol = 0;        // ���� col
        int curDist = 1;    // ���� �̵��� �Ÿ�
        String curPath = "";    // ������� �̵����
        
        // BFS������ ť�� ��������(0,0) ����
        LinkedList<Coord> queue = new LinkedList<Coord>();
        queue.add(new Coord(curRow, curCol, curDist, curPath));
        
        // ť�� empty�� ������ ����
        while(!queue.isEmpty()) {
            Coord coord = (Coord) queue.poll();
            curRow = coord.row;
            curCol = coord.col;
            curDist = coord.dist;
            curPath = coord.path;
            path = curPath;
            ret = curDist;
            map[curRow][curCol] = 0;
            
            // �������� �����ϸ� ���� ����
            if(curRow == rows - 1 && curCol == cols - 1) {
                break;
            }
            
            // ���� ���� ������
            if(curRow-1 >= 0 && map[curRow-1][curCol] == 1) {
                queue.add(new Coord(curRow-1, curCol, curDist+1, curPath));
            }
            // �Ʒ��� ���� ������
            if(curRow+1 < rows && map[curRow+1][curCol] == 1) {
                queue.add(new Coord(curRow+1, curCol, curDist+1, curPath));
            }
            // �������� ���� ������
            if(curCol-1 >= 0 && map[curRow][curCol-1] == 1) {
                queue.add(new Coord(curRow, curCol-1, curDist+1, curPath));
            }
            // ���������� ���� ������
            if(curCol+1 < cols && map[curRow][curCol+1] == 1) {
                queue.add(new Coord(curRow, curCol+1, curDist+1, curPath));
            }
        }
        
        // ť Ŭ����
        queue.clear();
        
        return ret;
    }
    
    // �̵��ϴ� ��ġ���� �� �Ÿ����� ����
    public static class Coord {
        int row, col, dist;
        String path;
        public Coord(int row, int col, int dist, String oldPath) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            if("".equals(oldPath)) {
                this.path = "(" + row + ", " + col + ")"; 
            }
            else {
                this.path = oldPath + " -> " + "(" + row + ", " + col + ")"; 
            }
        }
    }
}