package Three24_30.CanProblem;

/**
 * 水壶问题
 */
public class CanProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        //特殊情况
        if(x == 0||y == 0){
            if(z!=x&&z!=y){
                return false;
            }else {
                return true;
            }
        }
        if(z > x+y||z < 0){
            return false;
        }
        //求最大公因数，辗转相除法
        if(x < y){
            int tmp = x;
            x = y;
            y = tmp;
        }
        while (x!=0){
            int tmp = x % y;
            if(tmp !=0){
                x = y;
                y = tmp;
            }else {
                break;
            }
        }
        if(z % y == 0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        CanProblem test = new CanProblem();
        System.out.println(test.canMeasureWater(2,6,5));
    }
}
