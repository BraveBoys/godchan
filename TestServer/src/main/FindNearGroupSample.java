package main;

import java.util.ArrayList;

public class FindNearGroupSample {

    public static void main(String[] args) {
        
        int[][] matrix = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 2, 2, 2, 0},
            {0, 1, 0, 1, 0, 0, 2, 0, 2, 0},
            {0, 1, 0, 1, 0, 0, 2, 0, 2, 0},
            {0, 1, 1, 1, 0, 0, 2, 0, 2, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        
        ArrayList<Position> group = findGroup(matrix, new Position(5, 1));
        
        System.out.println(group);
        
        ArrayList<Position> group2 = findGroup(matrix, new Position(5, 2));
        
        System.out.println(group2);
    }

    private static ArrayList<Position> findGroup(int[][] matrix, Position position) {
        
        ArrayList<Position> group = new ArrayList<Position>();
        
        if(matrix[position.getRow()][position.getCol()] == 0) {
            return group;
        }
        
        // add first position to group
        group.add(position);
        
        // make source positions
        ArrayList<Position> pos = new ArrayList<Position>();
        pos.add(position);
        
        
        ArrayList<Position> nears = null;
        
        do {
            nears = findNear(matrix, pos);
            
            pos.clear();

            for (Position p : nears) {
                if(!group.contains(p)) {
                    group.add(p);
                    pos.add(p);
                }
            }
            
        }while(nears.size() > 0);
        
        
        return group;
    }

    private static ArrayList<Position> findNear(int[][] matrix, ArrayList<Position> pos) {
        
        ArrayList<Position> nears = new ArrayList<Position>();
        
        for (Position position : pos) {
            
            int num = matrix[position.getRow()][position.getCol()];
            
            if(position.getRow() - 1 > -1
                    && matrix[position.getRow() - 1][position.getCol()] == num) { // up
                nears.add(new Position(position.getRow() - 1, position.getCol()));
            }
            if(position.getRow() + 1 < matrix.length
                    && matrix[position.getRow() + 1][position.getCol()] == num) { // down
                nears.add(new Position(position.getRow() + 1, position.getCol()));
            }
            if(position.getCol() - 1 > -1
                    && matrix[position.getRow()][position.getCol() - 1] == num) { // left
                nears.add(new Position(position.getRow(), position.getCol() - 1));
            }
            if(position.getCol() + 1 < matrix[0].length
                    && matrix[position.getRow()][position.getCol() + 1] == num) { // right
                nears.add(new Position(position.getRow(), position.getCol() + 1));
            }
            
        }
        
        return nears;
    }
    
}


class Position{
    
    private int index;
    
    private int row;
    
    private int col;

    
    public Position(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public Position(int index, int x, int y) {
        super();
        this.index = index;
        this.row = x;
        this.col = y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        return row == ((Position)obj).getRow() && col == ((Position)obj).getCol();
    }
}
