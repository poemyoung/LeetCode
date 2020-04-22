package Two11_14.CountIslands;

public class CountIslands {
    /**
     * 递归寻找，见到一个'1'便赋值为0
     */
    private void findOne(int i,int j,char[][] arr){
        //基准条件
        if(i == -1||j == -1||i == arr.length||j == arr[0].length||arr[i][j] == '0'){
            return;
        }
        //递归条件
        arr[i][j] = '0';
        findOne(i+1,j,arr);
        findOne(i-1,j,arr);
        findOne(i,j+1,arr);
        findOne(i,j-1,arr);
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        //保留数组长度
        //行数
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        //列数
        int column = grid[0].length;
        //从第一排开始遍历到最后一排，从左到右
        //检查时只需检查右边的1和下方的1即可
        for(int i = 0;i < row;i++){
            for (int j = 0;j < column;j++){
                //从行往下和往右去寻找
                if(grid[i][j] == '1'){
                    res++;
                    findOne(i,j,grid);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountIslands test = new CountIslands();
        char[][] a = new char[4][5];
        char[][] b = new char[4][5];
        String[] aStr = {"11110","11010","11000","00000"};
        String[] bStr = {"11000","11000","00100","00011"};
        for (int i = 0;i < 4;i++){
            a[i] =  aStr[i].toCharArray();
        }
        System.out.println(test.numIslands(a));
    }
}
