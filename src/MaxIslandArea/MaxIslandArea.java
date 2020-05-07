package MaxIslandArea;

/**
 * 岛屿的最大面积，基于深度优先搜索
 */
public class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        //寻找到第一个1
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    //判断大小
                    int tmp = dfs(i,j,grid,grid.length,grid[0].length);
                    if(res < tmp){
                        res = tmp;
                    }
                }
            }
        }
        return res;
    }
    /**
     * 深度优先搜索算法
     */
    private int dfs(int row,int column,int[][] grid,int rowLen,int coLen){
        int res = 0;
        //基准条件
        if(grid[row][column] == 0){
            return 0;
        }else {
            res = 1;
            grid[row][column] = 0;
        }
        //递归条件
        if(row < rowLen - 1){
            res += dfs(row+1,column,grid,rowLen,coLen);
        }
        if(row > 0){
            res += dfs(row-1,column,grid,rowLen,coLen);
        }
        if(column < coLen - 1){
            res += dfs(row,column+1,grid,rowLen,coLen);
        }
        if(column > 0){
            res += dfs(row,column-1,grid,rowLen,coLen);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxIslandArea test = new MaxIslandArea();
        int[][] a = new int[8][13];
        a[0] = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        a[1] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        a[2] = new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0};
        a[3] = new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0};
        a[4] = new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0};
        a[5] = new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0};
        a[6] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        a[7] = new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0};
        System.out.println(test.maxAreaOfIsland(a));
        int[][] b = new int[4][5];
        b[0] = new int[]{1,1,0,0,0};
        b[1] = new int[]{1,1,0,0,0};
        b[2] = new int[]{0,0,0,1,1};
        b[3] = new int[]{0,0,0,1,1};
        System.out.println(test.maxAreaOfIsland(b));

    }
}
