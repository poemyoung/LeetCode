import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //队列
        LinkedList<String> queue = new LinkedList<>();
        int n = in.nextInt();
        //n 组操作
        for (int i = 0;i < n;i++){
            //操作个数
            int num = in.nextInt();
            //滤掉换行符
            in.nextLine();
            for (int j = 0;j < num;j++){
                String inp = in.nextLine();
                switch (inp){
                    case "TOP":
                        System.out.println(queue.peek() == null?-1:queue.peek());
                        break;
                    case "POP":
                        try{
                            queue.remove();
                        }catch (NoSuchElementException e){
                            System.out.println(-1);
                        }
                        break;
                    case "SIZE":
                        System.out.println(queue.size());
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                    default:
                        //push,需要拆分字符串
                        if(inp.contains("PUSH")){
                            //拆分出值
                            String[] a = inp.split(" ");
                            queue.add(a[1]);
                        }
                }
            }
        }
    }
}
