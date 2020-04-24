package CoinsCombine;

/**
 * 使用递归的方法去做
 */
public class CoinCombine {
    public int waysToChange(int n) {
        //特殊条件
        if(n == 0){
            return 0;
        }
        //非特殊条件，调用递归进行返回
        return recurCount(n);
    }
    public int recurCount(int unDeal){
        //基准条件
        if(unDeal == 0){
            return 1;
        }
        //计算个数的变量
        int count = 0;
        //递归条件
        count += (unDeal - 25) >= 0 ? recurCount(unDeal-25) : 0;
        count +=(unDeal - 10)  >=0 ? recurCount(unDeal - 10) : 0;
        count += (unDeal - 5) >=0 ? recurCount(unDeal - 5) : 0;
        count +=(unDeal -1) >= 0 ? recurCount(unDeal - 1) : 0;
        return count;
    }

    public static void main(String[] args) {
        CoinCombine test = new CoinCombine();
        System.out.println(test.waysToChange(9));
    }
}
