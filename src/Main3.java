import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    private static class Card{
        //卡片类
        int money;
        int chance;
        //标记是否删除
        boolean isDelete = false;

        public Card(int money, int chance) {
            this.money = money;
            this.chance = chance;
        }
    }

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<Card>cards = new ArrayList<>(num);
        for (int i = 0;i < num;i++){
            cards.add(new Card(in.nextInt(),in.nextInt()));
        }
        //剩余抽卡次数
        int chanceLeft = 1;
        //累计钱数
        int total = 0;
        //找可获得抽卡次数大于1的卡，全部抽光
        //惰性删除
        int size = cards.size();
        for (int j = 0;j < size;j++){
            if(cards.get(j).chance >= 1){
                chanceLeft += cards.get(j).chance - 1;
                total += cards.get(j).money;
                cards.get(j).isDelete = true;
            }
        }
        //真正的删除
        for (int j = 0;j < cards.size();j++){
            if(cards.get(j).isDelete){
                cards.remove(j);
                //回到刚才位置
                j--;
            }
        }
        //数组排序，目前只剩下抽卡次数为0的卡片
        //money由大到小排序
        //冒泡排序
        size = cards.size();
        for (int i = 0;i < size-1;i++){
            for (int j = size-2;j >= i;j--){
                if(cards.get(j).money<cards.get(j+1).money){
                    int temp = cards.get(j).money;
                    cards.get(j).money = cards.get(j+1).money;
                    cards.get(j+1).money = temp;
                }
            }
        }
        //从前往后抽卡直到次数用光
        for (int k = 0;k < size;k++){
            total += cards.get(k).money;
            chanceLeft--;
            if(chanceLeft == 0){
                break;
            }
        }
        System.out.println(total);
    }

}
