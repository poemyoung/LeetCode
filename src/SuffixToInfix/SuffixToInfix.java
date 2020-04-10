package SuffixToInfix;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * 后缀转中缀表达式算法
 */
public class SuffixToInfix {
    /**
     * 元素类，由字符串和字符串本身的状态组成（+、-、*、/、n）
     */
    private static class Elem{
        //本身表达式内容
       public String str;
       //状态
        public char ch;
        public Elem(String str,char ch){
            this.str = str;
            this.ch = ch;
        }
    }
    //结果栈，String类型
    Stack<Elem> results;
    //输入字符数组
    char[] input;
    //结果
    String res;
    public SuffixToInfix(String str){
        input = str.toCharArray();
        results = new Stack<>();
        deal();
    }
    //辅助函数：添加括号
    public String addBra(String unBra){
        return "("+unBra+")";
    }
    /**
     * 算法实现函数
     */
    public void deal(){
        //记录数字
        char[] num = new char[9];
        //记录是否有数字未被处理
        boolean flag  =false;
        //记录数字长度
        int k = 0;
        for (int i = 0;i < input.length;i++){
            if(Character.isDigit(input[i])){
                num[k++] = input[i];
                flag = true;
            }else if(input[i] == ' '){
                if(flag) {
                    results.push(new Elem(String.copyValueOf(num, 0, k),'n'));
                    flag = false;
                    num = new char[9];
                    k = 0;
                }
            }else {
                if(flag) {
                    results.push(new Elem(String.copyValueOf(num, 0, k),'n'));
                    flag = false;
                    num = new char[9];
                    k = 0;
                }
                //第一个弹出的字符串
                String temp = null;
                //新的字符串
                String newStr = null;
                //表达式状态
                char state;
                //弹出的元素1
                Elem popElem1 = null;
                //弹出的元素2
                Elem popElem2 = null;
                //新加入的元素
                Elem newElem = null;
                switch (input[i]){
                    //加号优先级最低，不用加括号
                    case '+':
                        temp = results.pop().str;
                        newElem = new Elem(results.pop().str+"+"+temp,'+');
                        break;
                    //减号，如果最顶上表达式是加法或者减法加括号
                    case '-':
                        //减数，判断要不要加括号
                        popElem1 = results.pop();
                        if(popElem1.ch == '+'||popElem1.ch == '-'){
                            newElem = new Elem(results.pop().str+'-'+addBra(popElem1.str),'-');
                        }else {
                            newElem = new Elem(results.pop().str+'-'+popElem1.str,'-');
                        }
                        break;
                    //乘号
                    case '*':
                        popElem1 = results.pop();
                        popElem2 = results.pop();
                        //加减需要加括号
                        if(popElem1.ch == '+'||popElem1.ch == '-'){
                            popElem1.str = addBra(popElem1.str);
                        }
                        if (popElem2.ch == '+'||popElem2.ch == '-'){
                            popElem2.str = addBra(popElem2.str);
                        }
                        newElem = new Elem(popElem2.str+'*'+popElem1.str,'*');
                        break;
                    case '/':
                        popElem1 = results.pop();
                        popElem2 = results.pop();
                        //加减乘除都需要加括号（前面乘除不用加括号）
                        if (popElem1.ch!='n'){
                            popElem1.str = addBra(popElem1.str);
                        }
                        if (popElem2.ch == '+'||popElem2.ch == '-'){
                            popElem2.str = addBra(popElem2.str);
                        }
                        newElem = new Elem(popElem2.str+"/"+popElem1.str,'/');
                        break;
                    default:
                        System.out.println("输入不合法");
                        return;
                }
//                新元素入栈
                results.push(newElem);
            }
        }
    }
    /**
     * 最终形成结果方法
     */
    public String getRes(){
        return results.pop().str;
    }
    /**
     * 测试方法
     */
    public static void main(String[] args) {
        SuffixToInfix test = new SuffixToInfix("100 32 58 32 6 - - - 4 / / ");
        System.out.println(test.getRes());
    }

}
