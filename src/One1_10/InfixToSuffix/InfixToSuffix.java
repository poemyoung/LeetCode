package One1_10.InfixToSuffix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 中缀转后缀
 */
public class InfixToSuffix {
    //使用java自带的堆栈
    //队列1,结果队列（栈）
    Queue<String> results;
    //堆栈2，符号栈
    Stack<Character> symbols;
    //待转的中缀表达式
    char[] infix;
    //中缀表达式剩余长度
    int leftSize;
    //结果
    String res;
    public InfixToSuffix(String str){
        infix = str.toCharArray();
        leftSize = infix.length;
        results = new LinkedList<String>();
        symbols = new Stack<>();
        deal();
    }
    /**
     * 转算法
     */
    public void deal(){
        //记录数字
        char[] num = new char[9];
        //记录是否有数字未被处理
        boolean flag  =false;
        //记录数字长度
        int k = 0;
        for (int i = 0;i < infix.length;i++){
            //如果是数字，放进num中
            if(Character.isDigit(infix[i])){
                num[k++] = infix[i];
                flag = true;
            }else if (infix[i] == ' '){
                //处理数字
                if(flag) {
                    results.add(String.copyValueOf(num, 0, k));
                    results.add(" ");
                    flag = false;
                    num = new char[9];
                    k = 0;
                }
            }else {
                //符号
                if(flag) {
                    results.add(String.copyValueOf(num, 0, k));
                    results.add(" ");
                    flag = false;
                    num = new char[9];
                    k = 0;
                }
                //判断符号种类然后操作
                //1，判断符号栈是否为空
                if(symbols.isEmpty()){
                    symbols.push(infix[i]);
                }else {
                    //不为空
                    //判断该符号本身是不是左括号或右括号
                    switch (infix[i]){
                        case '(':
                            symbols.push('(');
                            break;
                        case ')':
                            //弹出至左括号
                            while (!symbols.isEmpty()&&symbols.peek()!='('){
                                results.add(String.valueOf((char)symbols.pop()));
                                results.add(" ");
                            }
                            if(symbols.peek() == '('){
                                symbols.pop();
                            }
                            break;
                        default:
                            while (!symbols.isEmpty()&&priority(infix[i]) <= priority(symbols.peek())){
                                results.add(String.valueOf((char)symbols.pop()));
                                results.add(" ");
                            }
                            //弹出完了之后压栈
                            symbols.push(infix[i]);
                    }

                }
            }
        }
        if(flag) {
            results.add(String.copyValueOf(num, 0, k));
            results.add(" ");
            flag = false;
            num = new char[9];
            k = 0;
        }
        //把栈中剩下的符号全部弹出来
        while (!symbols.isEmpty()){
            results.add(String.valueOf((char)symbols.pop()));
            results.add(" ");
        }
    }
    private int priority(char a){
        switch (a){
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
            case ')':
                return 0;
            default:
                System.out.println(a+"符号不对！");
                return 0;
        }
    }

    public String getRes(){
        StringBuilder builder = new StringBuilder();
       while (!results.isEmpty()){
           builder.append(results.remove());
       }
       return builder.toString();
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        InfixToSuffix test = new InfixToSuffix("100/((32-(58 - (32-6)))/4)");
        System.out.println(test.getRes());
    }

}
