package leetcode.dataStructure.problems;

/**
 * DFS floodfile 不需要回溯动作
 * BFS
 * 并查集
 */
public class LC200NumberOfIslands {
    public static int m;
    public static int n;
    public static boolean[][] visited;

    public static int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for ( int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == '1' && !visited[x][y]) {
                    count++;
                    dfs(grid, x, y);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int x, int y) {
        // 退出条件
        if (!inGrid(x, y))
            return;
        if (grid[x][y] != '1' )
            return;
        if (visited[x][y])
            return;

        // 选择并处理
        visited[x][y] = true;
        // 循环四个方向
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);

        return;
    }

    public static boolean inGrid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(arr));
    }
}
