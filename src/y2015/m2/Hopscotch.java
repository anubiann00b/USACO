package y2015.m2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hopscotch {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("hopscotch.in"));
        
        String[] dims = reader.readLine().split(" ");
        int r = Integer.valueOf(dims[0]);
        int c = Integer.valueOf(dims[1]);
        
        boolean[][] map = new boolean[r][c];
        int[][] sols = new int[r][c];
        
        for (int i=0;i<r;i++) {
            String row = reader.readLine();
            for (int j=0;j<c;j++) {
                map[i][j] = row.charAt(j)=='R';
                sols[i][j] = -1;
            }
        }
        
        int solution = recursiveSolve(map, sols, r, c, 0, 0);
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("hopscotch.out"));
        writer.write(String.valueOf(solution));
        writer.flush();
    }
    
    static int recursiveSolve(boolean[][] map, int[][] sols, int r, int c, int x, int y) {
        if (sols[x][y] != -1)
            return sols[x][y];
        
        if (x == r-1 && y == c-1)
            return 1;
        if (x == r-1 || y == c-1)
            return 0;
        
        int sum = 0;
        for (int i=x+1;i<r;i++) {
            for (int j=y+1;j<c;j++) {
                if (map[i][j] != map[x][y])
                    sum += recursiveSolve(map, sols, r, c, i, j);
            }
        }
        
        sols[x][y] = sum;
        return sum;
    }
}
